package ie.nci.journey.manager;

import ie.nci.journey.entity.Comment;
import ie.nci.journey.mapper.CommentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static ie.nci.journey.entity.Comment.COMMENT_VALID;

/**
 * CommentManagerImpl
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2024-01-01
 */
@Service
public class CommentManagerImpl implements CommentManager {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public void deleteById(Long id) {
        commentMapper.deleteById(id);
    }

    @Override
    public Comment create(Comment comment) {
        comment.setStatus(COMMENT_VALID);
        comment.setCreateTime(new Date());
        commentMapper.insert(comment);

        return comment;
    }

    @Override
    public List<Comment> selectByBlogId(Long blogId) {
        return commentMapper.selectByBlogId(blogId);
    }
}
