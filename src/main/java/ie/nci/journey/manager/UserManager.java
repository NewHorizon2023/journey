package ie.nci.journey.manager;

import ie.nci.journey.entity.User;

import java.util.List;

public interface UserManager {

    User userRegister(User user);

    List<User> selectByUsername(String username);
}
