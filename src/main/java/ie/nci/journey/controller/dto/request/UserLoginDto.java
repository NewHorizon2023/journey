package ie.nci.journey.controller.dto.request;

/**
 * LoginDto
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-12-30
 */
public class UserLoginDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
