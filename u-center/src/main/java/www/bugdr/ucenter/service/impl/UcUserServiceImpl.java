package www.bugdr.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import www.bugdr.common.response.R;
import www.bugdr.common.utils.Constants;
import www.bugdr.common.utils.RedisUtils;
import www.bugdr.common.utils.TextUtils;
import www.bugdr.ucenter.pojo.UcUser;
import www.bugdr.ucenter.mapper.UcUserMapper;
import www.bugdr.ucenter.pojo.UcUserInfo;
import www.bugdr.ucenter.service.IUcUserInfoService;
import www.bugdr.ucenter.service.IUcUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import www.bugdr.ucenter.vo.RegisterVo;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bugdr
 * @since 2022-01-21
 */
@Slf4j
@Service
public class UcUserServiceImpl extends ServiceImpl<UcUserMapper, UcUser> implements IUcUserService {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private IUcUserInfoService iUcUserInfoService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 添加用户
     *
     * @param emailCode
     * @param registerVo
     * @return
     */
    @Override
    public R addUser(String emailCode, RegisterVo registerVo) {
        String email = registerVo.getEmail();
        String password = registerVo.getPassword();
        String name = registerVo.getName();
        log.info("registerVo ==> {}", registerVo);
        if (TextUtils.isEmpty(email)) {
            return R.FAILED("注册邮箱不可以为空.");
        }
        if (TextUtils.isEmpty(password)) {
            return R.FAILED("密码不可以为空.");
        }
        if (TextUtils.isEmpty(name)) {
            return R.FAILED("昵称不可以为空.");
        }
        //校验邮箱验证码
        String emailCodeRecord = (String) redisUtils.get(Constants.User.KEY_EMAIL_CODE + email);
        if (TextUtils.isEmpty(emailCodeRecord) || !emailCodeRecord.equals(emailCode)) {
            return R.FAILED("邮箱验证码不正确.");
        }
        //密码长度校验，长度为32位，md5
        if (password.length() != 32) {
            return R.FAILED("请使用MD5加密算法进行装换.");
        }
        //判断邮箱是否有注册
        QueryWrapper<UcUserInfo> emailQueryWrapper = new QueryWrapper<>();
        emailQueryWrapper.eq("email", email);
        emailQueryWrapper.select("id");
        UcUserInfo ucUserInfo = iUcUserInfoService.getBaseMapper().selectOne(emailQueryWrapper);
        if (ucUserInfo != null) {
            return R.FAILED("该邮箱已经被注册.");
        }
        //判断用户名是否有被注册掉
        QueryWrapper<UcUser> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name", name);
        userQueryWrapper.select("id");
        UcUser ucUser = this.baseMapper.selectOne(userQueryWrapper);
        if (ucUser != null) {
            return R.FAILED("该用户名已经被注册.");
        }
        //加密
        String targetPassword = bCryptPasswordEncoder.encode(password);
        //设置头像和状态
        UcUser targetUser = new UcUser();
        targetUser.setAvatar(Constants.User.DEFAULT_AVATAR);
        targetUser.setUserName(name);
        targetUser.setPassword(targetPassword);
        targetUser.setStatus(Constants.User.STATUS_NORMAL);
        //入库
        this.baseMapper.insert(targetUser);
        //返回结果
        return R.SUCCESS("注册成功.");
    }
}
