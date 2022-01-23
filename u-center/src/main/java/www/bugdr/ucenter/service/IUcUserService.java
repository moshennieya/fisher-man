package www.bugdr.ucenter.service;

import www.bugdr.common.response.R;
import www.bugdr.ucenter.pojo.UcUser;
import com.baomidou.mybatisplus.extension.service.IService;
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

    R addUser(String emailCode, RegisterVo registerVo);
}
