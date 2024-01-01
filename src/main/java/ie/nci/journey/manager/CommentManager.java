package ie.nci.journey.manager;

import ie.nci.journey.entity.Comment;

import java.util.List;

public interface CommentManager {

    void deleteById(Long id);

    Comment create(Comment comment);

    List<Comment> selectByBlogId(Long blogId);
}
