package ie.nci.journey.mapper;

import ie.nci.journey.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(User user);
}
