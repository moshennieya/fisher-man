package www.bugdr.ucenter.vo;

import lombok.Data;

@Data
public class RegisterVo {
    //邮箱
    private String email;
    //昵称
    private String name;
    //密码
    private String password;
}
