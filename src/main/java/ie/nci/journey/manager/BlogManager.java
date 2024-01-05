package ie.nci.journey.manager;

import ie.nci.journey.entity.Blog;

import java.util.List;

public interface BlogManager {

    List<Blog> selectAll();

    void update(Blog blog);

    void deleteById(Long id);

    Blog selectById(Long id);

    Blog createBlog(Blog blog);
}
