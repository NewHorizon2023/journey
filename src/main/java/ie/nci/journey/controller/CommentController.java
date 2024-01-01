package ie.nci.journey.controller;

import ie.nci.journey.controller.dto.Response;
import ie.nci.journey.controller.dto.request.CommentDto;
import ie.nci.journey.entity.Comment;
import ie.nci.journey.entity.User;
import ie.nci.journey.manager.CommentManager;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

import static ie.nci.journey.controller.constant.UserConstant.USER_KEY;
import static ie.nci.journey.entity.User.ACCOUNT_TYPE_ADMIN;

/**
 * Controller
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2024-01-01
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentManager commentManager;

    @PostMapping("/submit")
    public String submit(@ModelAttribute Comment comment, HttpSession session) {
        User user = (User) session.getAttribute(USER_KEY);

        if (user == null) {
            return "redirect:/";
        }

        comment.setAuthorId(user.getId());
        comment.setAuthorName(user.getUsername());
        commentManager.create(comment);

        return "redirect:/blog/detail?" + comment.getBlogId();
    }

    @PostMapping("/delete")
    public Response<Objects> delete(@RequestBody CommentDto commentDto, HttpSession session) {
        User user = (User) session.getAttribute(USER_KEY);

        if (user == null || user.getType() != ACCOUNT_TYPE_ADMIN && !Objects.equals(user.getId(), commentDto.getAuthorId())) {
            return Response.error("You don't have the permission to do this.");
        }

        commentManager.deleteById(commentDto.getCommentId());

        return Response.ok();
    }
}
