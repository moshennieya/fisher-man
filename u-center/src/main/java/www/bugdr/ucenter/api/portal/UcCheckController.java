package www.bugdr.ucenter.api.portal;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import www.bugdr.common.response.R;

/**
 * <p>
 * 前端控制器
 * </p>
 * <p>
 * 帮助用户类实现基本功能的工具接口，比如说验证码，邮箱是否有注册检查，用户名是否有注册检查之类的
 * <p>
 * 获取验证码，captcha（get）
 * 获取邮箱验证码，email_code (get)
 * 检查邮箱是否有注册 email（get）
 * 检查手机号是否有注册 phone (get)
 * 检查用户名是否有注册 user_name （get）
 * 检查token是否有效 token (get)
 *
 * @author bugdr
 * @since 2022-01-21
 */
@RestController
public class UcCheckController {

    @GetMapping("/check/captcha")
    public R getVerifyCode() {
        return null;
    }

    @GetMapping("/check/phone_num")
    public R checkPhoneNum() {
        return null;
    }

    @GetMapping("/check/phone_verify_code")
    public R getPhoneVerifyCode() {
        return null;
    }

    @GetMapping("/check/email")
    public R checkEmail() {
        return null;
    }

    @GetMapping("/check/email_verify_code")
    public R getEmailVerifyCode() {
        return null;
    }

}

