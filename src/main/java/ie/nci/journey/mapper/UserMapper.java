package ie.nci.journey.mapper;

import ie.nci.journey.controller.dto.request.UserLoginDto;
import ie.nci.journey.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(User user);

    List<User> selectByUsername(String username);

    User selectByUsernamePassword(UserLoginDto userLoginDto);
}
