package ie.nci.journey.mapper;

import ie.nci.journey.entity.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * UserMapperTest
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-15
 */
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setName("Lao Wang");
        user.setPassword("321");
        user.setCreateTime(new Date());
        userMapper.insert(user);
    }
}
