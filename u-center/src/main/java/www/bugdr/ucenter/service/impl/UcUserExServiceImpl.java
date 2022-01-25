package www.bugdr.ucenter.service.impl;

import com.anji.captcha.model.common.RepCodeEnum;
import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaCacheService;
import com.anji.captcha.service.CaptchaService;
import com.anji.captcha.service.impl.CaptchaServiceFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.bugdr.common.response.R;
import www.bugdr.common.utils.Constants;
import www.bugdr.common.utils.RedisUtils;
import www.bugdr.common.utils.TextUtils;
import www.bugdr.ucenter.base.BaseService;
import www.bugdr.ucenter.mapper.UcUserMapper;
import www.bugdr.ucenter.pojo.UcUser;
import www.bugdr.ucenter.pojo.UcUserInfo;
import www.bugdr.ucenter.service.IUcUserExService;
import www.bugdr.ucenter.service.IUcUserInfoService;
import www.bugdr.ucenter.utils.EmailSendUtils;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class UcUserExServiceImpl extends BaseService<UcUserMapper, UcUser> implements IUcUserExService {


    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private IUcUserInfoService iUcUserInfoService;

    @Autowired
    private CaptchaService captchaService;

    /**
     * 发送邮箱验证码
     *
     * @param verifition    验证码校验
     * @param emaillAddress 邮箱地址
     * @param mustRegister  邮箱地址是否已经检查注册
     * @return
     */
    @Override
    public R sendEmailCode(String verifition, String emaillAddress, boolean mustRegister) {
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaVerification(verifition);
        //这种验证方式会删除，只能验证一次
        ResponseModel response = captchaService.verification(captchaVO);
        String reqCode = response.getRepCode();
        if (!response.isSuccess()) {
            //验证码校验失败，返回信息告诉前端
            //repCode  0000  无异常，代表成功
            //repCode  9999  服务器内部异常
            //repCode  0011  参数不能为空
            //repCode  6110  验证码已失效，请重新获取
            //repCode  6111  验证失败
            //repCode  6112  获取验证码失败,请联系管理员
            if (reqCode != null && reqCode.equals(RepCodeEnum.API_CAPTCHA_COORDINATE_ERROR.getCode())) {
                return R.FAILED(RepCodeEnum.API_CAPTCHA_COORDINATE_ERROR.getDesc());
            } else if (reqCode == null || !reqCode.equals(RepCodeEnum.SUCCESS.getCode())) {
                return R.FAILED("图灵验证码失败.");
            }
        }
        //先检查数据
        if (TextUtils.isEmpty(emaillAddress)) {
            return R.FAILED("邮箱地址不可以为空.");
        }
        // //对邮箱地址进行校验
        String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(emaillAddress);
        if (!m.matches()) {
            return R.FAILED("请检查邮箱格式.");
        }
        //不管是true or false，都有查邮箱是否存在
        QueryWrapper<UcUserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", emaillAddress);
        queryWrapper.select("id");
        UcUserInfo ucUserInfo = iUcUserInfoService.getBaseMapper().selectOne(queryWrapper);
        //存在邮箱
        if (ucUserInfo != null && !mustRegister) {
            return R.FAILED("该邮箱已经被注册.");
        }
        if (ucUserInfo == null && mustRegister) {
            return R.FAILED("该邮箱未注册.");
        }
        //防止恶意频繁调用，可以通过ip，通过邮箱地址
        String remoteAddr = getRequest().getRemoteAddr();
        log.info("remoteAddr ==> ", remoteAddr);
        remoteAddr = remoteAddr.replaceAll(":", "-");
        //组合key和ip
        String ipKey = Constants.User.KEY_EMAIL_CODE_IP + remoteAddr;
        //判断是否有多次请求，2小时超过20次，就返回频繁请求
        String ipTime = (String) redisUtils.get(ipKey);
        if (!TextUtils.isEmpty(ipTime)) {
            int i = Integer.parseInt(ipTime);
            log.info("当前ip{}调用了{}次", remoteAddr, i);
            if (i > 20) {
                return R.FAILED("请不要频繁发送验证码，多次发送将被拉黑.");
            } else {
                i++;
                redisUtils.set(ipKey, String.valueOf(i), Constants.TimeSecond.TWO_HOUR);
            }
        } else {
            //两小时有效
            redisUtils.set(ipKey, "1", Constants.TimeSecond.TWO_HOUR);
        }

        /**
         * 邮箱拦截，不予许调用20次以上
         */
        //组合key和ip
        String addressKey = Constants.User.KEY_EMAIL_CODE_ADDRESS + remoteAddr;
        //判断是否有多次请求，2小时超过20次，就返回频繁请求
        String addressTime = (String) redisUtils.get(addressKey);
        if (!TextUtils.isEmpty(addressTime)) {
            int i = Integer.parseInt(addressTime);
            log.info("当前邮箱{}调用了{}次", emaillAddress, i);
            if (i > 20) {
                return R.FAILED("请不要频繁发送验证码，多次发送将被拉黑.");
            } else {
                i++;
                redisUtils.set(addressKey, String.valueOf(i), Constants.TimeSecond.TWO_HOUR);
            }
        } else {
            //两小时有效
            redisUtils.set(addressKey, "1", Constants.TimeSecond.TWO_HOUR);
        }
        //产生验证码，记录验证码
        Random random = new Random();
        //产生6为的验证码，000000~999999
        int emailCode = random.nextInt(999999);
        if (emailCode < 100000) {
            emailCode += 100000;
        }
        log.info("email code ==>" + emailCode);
        //保存验证码到redis,五分钟过期
        redisUtils.set(Constants.User.KEY_EMAIL_CODE + emaillAddress, String.valueOf(emailCode),
                Constants.TimeSecond.FIVE_MIN);
        //发送验证码
        EmailSendUtils.sendEmailCode(emaillAddress, "验证码：" + emailCode + ", 5分钟之内有效");
        return R.SUCCESS("邮箱验证码发送成功.");
    }

}
