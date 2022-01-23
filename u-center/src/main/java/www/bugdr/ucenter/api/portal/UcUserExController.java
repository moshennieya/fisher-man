package www.bugdr.ucenter.api.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import www.bugdr.common.response.R;
import www.bugdr.ucenter.service.IUcUserExService;

import javax.servlet.http.HttpServletRequest;

/**
 * 拓展接口
 * 1、发送邮箱验证码
 * 2、检查邮箱是否注册
 * 3、检查用户名是否已注册
 */

@RestController
public class UcUserExController {

    @Autowired
    private IUcUserExService iUcUserExService;

    /**
     * 发送邮箱验证码
     */
    @GetMapping("/uc/send/re/email-code")
    public R sendRegisterEmailCode(@RequestParam("email") String emaillAddress) {
        return iUcUserExService.sendEmailCode(emaillAddress, false);
    }
}
