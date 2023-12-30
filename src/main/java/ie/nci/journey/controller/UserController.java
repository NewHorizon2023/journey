package ie.nci.journey.controller;

import ie.nci.journey.controller.dto.request.UserLoginDto;
import ie.nci.journey.entity.User;
import ie.nci.journey.manager.UserManager;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * UserController
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-12-30
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserManager userManager;

    @GetMapping("/register")
    public String userRegister() {
        return "page/user-register";
    }

    @PostMapping("/registerSubmit")
    public String registerProcess(@ModelAttribute User user, Model model) {
        List<User> users = userManager.selectByUsername(user.getUsername());

        if (!CollectionUtils.isEmpty(users)) {
            model.addAttribute("userExisted", "This username is existed, please try another one.");
            return "page/user-register";
        }

        userManager.userRegister(user);

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto, HttpSession session) {
        User user = userManager.selectByUsernamePassword(userLoginDto);
        session.setAttribute("user", user);

        if (user == null) {
            session.setAttribute("loginFail", "fail");
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

}
