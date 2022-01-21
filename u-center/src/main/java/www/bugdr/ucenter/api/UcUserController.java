package www.bugdr.ucenter.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import www.bugdr.common.response.R;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author bugdr
 * @since 2022-01-21
 */
@RestController
@RequestMapping("/ucenter/ucUser")
public class UcUserController {

    @GetMapping("/test")
    public R testResponse() {
        return R.SUCCESS("请求成功");
    }
}

