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

import static ie.nci.journey.controller.constant.UserConstant.USER_KEY;

/**
 * AdminController
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2024-01-02
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private UserManager userManager;

    @GetMapping("/register")
    public String register() {
        return "page/admin-register";
    }

    @PostMapping("/registerSubmit")
    public String registerSubmit(@ModelAttribute User user, Model model) {
        List<User> users = userManager.selectByUsername(user.getUsername());

        if (!CollectionUtils.isEmpty(users)) {
            model.addAttribute("adminExisted", "This admin account is existed, please try another one.");
            return "page/admin-register";
        }

        user.setType(User.ACCOUNT_TYPE_ADMIN);
        userManager.userRegister(user);

        return "redirect:/admin/login";
    }

    @GetMapping("/login")
    public String login() {
        return "page/admin-login";
    }

    @PostMapping("/loginSubmit")
    public String login(@ModelAttribute UserLoginDto userLoginDto, HttpSession session) {
        User user = userManager.selectByUsernamePassword(userLoginDto);
        session.setAttribute(USER_KEY, user);

        if (user == null) {
            session.setAttribute("adminLoginFail", "fail");
            return "redirect:/admin/login";
        }

        return "redirect:/";
    }
}
