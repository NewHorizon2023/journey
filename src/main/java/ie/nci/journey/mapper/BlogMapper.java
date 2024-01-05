package ie.nci.journey.mapper;

import ie.nci.journey.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {

    List<Blog> selectAll();

    void insert(Blog blog);

    void update(Blog blog);

    void deleteById(Long id);

    Blog selectById(Long id);

}
