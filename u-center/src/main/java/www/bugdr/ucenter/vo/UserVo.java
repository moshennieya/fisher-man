package www.bugdr.ucenter.vo;

import lombok.Data;

@Data
public class UserVo {
    //id
    private String id;
    //sex
    private String sex;
    //盐
    private String salt;
    //状态
    private String status;
    //头像
    private String avatar;
    //密码
    private String password;
    //用户名
    private String userName;
}
