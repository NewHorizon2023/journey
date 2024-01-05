package ie.nci.journey.controller;

import ie.nci.journey.controller.dto.Response;
import ie.nci.journey.controller.dto.request.BlogDto;
import ie.nci.journey.entity.Blog;
import ie.nci.journey.entity.Comment;
import ie.nci.journey.entity.User;
import ie.nci.journey.manager.BlogManager;
import ie.nci.journey.manager.CommentManager;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static ie.nci.journey.controller.constant.UserConstant.USER_KEY;
import static ie.nci.journey.entity.User.ACCOUNT_TYPE_ADMIN;

/**
 * BlogController
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2024-01-01
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogManager blogManager;
    @Resource
    private CommentManager commentManager;

    @GetMapping("/list")
    public String blogList(HttpSession session, Model model) {
        List<Blog> blogList = blogManager.selectAll();
        model.addAttribute("blogList", blogList);

        User user = (User) session.getAttribute(USER_KEY);
        model.addAttribute(USER_KEY, user);

        return "page/blog-list";
    }

    @GetMapping("/detail")
    public String blogDetail(@RequestParam Long id, HttpSession session, Model model) {
        Blog blog = blogManager.selectById(id);

        if (blog == null) {
            return "redirect:/blog/list";
        }

        model.addAttribute("blog", blog);
        User user = (User) session.getAttribute(USER_KEY);
        model.addAttribute(USER_KEY, user);

        List<Comment> commentList = commentManager.selectByBlogId(id);
        model.addAttribute("commentList", commentList);

        return "page/blog-detail";
    }

    @GetMapping("/editor")
    public String editor(@RequestParam Long id, Model model) {
        if (id == null) {
            model.addAttribute("blog", null);
            return "page/blog-editor";
        }

        Blog blog = blogManager.selectById(id);
        model.addAttribute("blog", blog);

        return "page/blog-editor";
    }

    @ResponseBody
    @PostMapping("/submit")
    public Response<Blog> submit(@RequestBody Blog blog, HttpSession session) {
        User user = (User) session.getAttribute(USER_KEY);

        if (user == null) {
            return Response.error("You need to login.");
        }

        blog.setAuthorId(user.getId());
        blog = blogManager.createBlog(blog);

        return Response.ok(blog);
    }

    @ResponseBody
    @PostMapping("/update")
    public Response<Blog> update(@RequestBody Blog blog, HttpSession session) {
        Blog oldBlog = blogManager.selectById(blog.getId());
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setContent(blog.getContent());
        blogManager.update(oldBlog);

        return Response.ok(oldBlog);
    }

    @ResponseBody
    @PostMapping("/delete")
    public Response<BlogDto> delete(@RequestBody BlogDto blogDto, HttpSession session) {
        User user = (User) session.getAttribute(USER_KEY);

        if (user == null || user.getType() != ACCOUNT_TYPE_ADMIN && !Objects.equals(user.getId(), blogDto.getAuthorId())) {
            return Response.error("You need to login.");
        }

        blogManager.deleteById(blogDto.getBlogId());
        return Response.ok(blogDto);
    }

}
