package ie.nci.journey.mapper;

import ie.nci.journey.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    void deleteById(Long id);

    void insert(Comment comment);

    List<Comment> selectByBlogId(Long blogId);
}
