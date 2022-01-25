package www.bugdr.ucenter.utils;

import www.bugdr.ucenter.pojo.UcUser;
import www.bugdr.ucenter.vo.LoginBean;
import www.bugdr.ucenter.vo.UserVo;

import java.util.HashMap;
import java.util.Map;

public class ClaimsUtils {
    public static Map<String, Object> user2Claims(UcUser userByAccount) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userByAccount.getId());
        claims.put("sex", userByAccount.getSex());
        claims.put("status", userByAccount.getStatus());
        claims.put("avatar", userByAccount.getAvatar());
        claims.put("userName", userByAccount.getUserName());
        return claims;
    }

    public static UserVo claims2User(Map<String, Object> claims) {
        UserVo userVo = new UserVo();
        String id = (String) claims.get("id");
        userVo.setId(id);
        String sex = (String) claims.get("sex");
        userVo.setSex(sex);
        String status = (String) claims.get("status");
        userVo.setStatus(status);
        String avatar = (String) claims.get("avatar");
        userVo.setAvatar(avatar);
        String userName = (String) claims.get("userName");
        userVo.setUserName(userName);
        return userVo;
    }
}
