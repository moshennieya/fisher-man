package www.bugdr.ucenter.service.impl;

import www.bugdr.ucenter.pojo.UcUser;
import www.bugdr.ucenter.mapper.UcUserMapper;
import www.bugdr.ucenter.service.IUcUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bugdr
 * @since 2022-01-21
 */
@Service
public class UcUserServiceImpl extends ServiceImpl<UcUserMapper, UcUser> implements IUcUserService {

}
