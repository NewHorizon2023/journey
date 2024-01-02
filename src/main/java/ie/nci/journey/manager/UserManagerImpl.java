package ie.nci.journey.manager;

import ie.nci.journey.controller.dto.request.UserLoginDto;
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
        userMapper.insert(user);

        return user;
    }

    @Override
    public List<User> selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User selectByUsernamePassword(UserLoginDto userLoginDto) {
        return userMapper.selectByUsernamePassword(userLoginDto);
    }
}
