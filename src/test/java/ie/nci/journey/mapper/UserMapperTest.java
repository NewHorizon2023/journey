package ie.nci.journey.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void testInsertUser() {
    }
}
