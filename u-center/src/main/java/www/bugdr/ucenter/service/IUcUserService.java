package www.bugdr.ucenter.service;

import www.bugdr.common.response.R;
import www.bugdr.ucenter.pojo.UcUser;
import com.baomidou.mybatisplus.extension.service.IService;
import www.bugdr.ucenter.vo.LoginVo;
import www.bugdr.ucenter.vo.RegisterVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author bugdr
 * @since 2022-01-21
 */
public interface IUcUserService extends IService<UcUser> {

    /**
     * 添加用户
     * @param emailCode
     * @param registerVo
     * @return
     */
    R addUser(String emailCode, RegisterVo registerVo);

    /**
     * 登录
     * @param loginVo
     * @return
     */
    R login(LoginVo loginVo, String verifition);
}
