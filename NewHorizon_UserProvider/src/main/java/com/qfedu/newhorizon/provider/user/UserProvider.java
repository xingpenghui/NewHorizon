package com.qfedu.newhorizon.provider.user;
import com.qfedu.newhorizon.common.redis.RedisUtil;
import com.qfedu.newhorizon.common.result.R;
import com.qfedu.newhorizon.domain.user.UserMain;
import com.qfedu.newhorizon.mapper.user.UserMapper;
import com.qfedu.newhorizon.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Kam
 * @Date: 下午 7:37 2018-09-17
 * @Description: 用户服务实现
 * @Version: 1.0
 */
@Service
public class UserProvider implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil ru;

    @Override
    public R register(UserMain user) {
        return userMapper.insert(user)>0?R.OK():R.ERROR();
    }
}