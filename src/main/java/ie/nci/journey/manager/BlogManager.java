package ie.nci.journey.manager;

import ie.nci.journey.entity.Blog;

import java.util.List;

public interface BlogManager {

    List<Blog> selectAll();

    void deleteById(Long id);

    Blog createBlog(Blog blog);

    Blog selectById(Long id);
}
