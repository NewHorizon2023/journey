package ie.nci.journey.manager;

import ie.nci.journey.entity.User;
import ie.nci.journey.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * UserManagerImpl
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-12-30
 */
@Service
public class UserManagerImpl implements UserManager {

    @Resource
    private UserMapper userMapper;

    @Override
    public User userRegister(User user) {
        user.setCreateTime(new Date());
        user.setType(User.ACCOUNT_TYPE_USER);
        userMapper.insert(user);

        return user;
    }

    @Override
    public List<User> selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
}
