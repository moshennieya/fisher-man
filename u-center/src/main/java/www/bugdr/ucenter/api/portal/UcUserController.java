package www.bugdr.ucenter.api.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import www.bugdr.common.response.R;
import www.bugdr.common.utils.RedisUtils;

/**
 * <p>
 * 前端控制器
 * </p>
 * <p>
 * 获取图灵验证 captcha (get)
 * 检查当前手机号码是否有被注册 phone_num (get)
 * 获取手机验证码 phone_verify_code （get）
 * 检查当前邮箱是否有被注册 email (get)
 * 获取邮箱验证码 email_verify_code (get)
 * 检查昵称是否有被使用 nickname (get)
 * 提交注册信息 sign_up (post)
 *
 * @author bugdr
 * @since 2022-01-21
 */
@RestController
public class UcUserController {

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping("/uc/user")
    public R register() {
        redisUtils.set("test", "testContent",10);
        String content = (String) redisUtils.get("test");
        return R.SUCCESS("读写成功").setData(content);
    }
}
