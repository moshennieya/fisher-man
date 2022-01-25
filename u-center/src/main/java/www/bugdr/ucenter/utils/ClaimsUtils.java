package www.bugdr.ucenter.utils;

import www.bugdr.ucenter.vo.UserVo;

import java.util.HashMap;
import java.util.Map;

public class ClaimsUtils {
    public static Map<String, Object> user2Claims(UserVo userByAccount) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", userByAccount.getId());
        claims.put("sex", userByAccount.getSex());
        claims.put("salt", userByAccount.getSalt());
        claims.put("status", userByAccount.getStatus());
        claims.put("avatar", userByAccount.getAvatar());
        claims.put("password", userByAccount.getPassword());
        claims.put("userName", userByAccount.getUserName());
        return claims;
    }

    public static UserVo claims2User(Map<String, Object> claims) {
        UserVo userVo = new UserVo();
        String id = (String) claims.get("id");
        userVo.setId(id);
        String sex = (String) claims.get("sex");
        userVo.setSex(sex);
        String salt = (String) claims.get("salt");
        userVo.setSalt(salt);
        String status = (String) claims.get("status");
        userVo.setSalt(status);
        String avatar = (String) claims.get("avatar");
        userVo.setAvatar(avatar);
        String password = (String) claims.get("password");
        userVo.setPassword(password);
        String userName = (String) claims.get("userName");
        userVo.setUserName(userName);
        return userVo;
    }
}
