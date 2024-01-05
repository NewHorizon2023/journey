package ie.nci.journey.manager;

import ie.nci.journey.entity.Blog;
import ie.nci.journey.mapper.BlogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * BlogManagerImpl
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2024-01-01
 */
@Service
public class BlogManagerImpl implements BlogManager {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public List<Blog> selectAll() {
        return blogMapper.selectAll();
    }

    @Override
    public void update(Blog blog) {
        blog.setUpdateTime(new Date());
        blogMapper.update(blog);
    }

    @Override
    public void deleteById(Long id) {
        blogMapper.deleteById(id);
    }

    @Override
    public Blog createBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setStatus(Blog.BLOG_VALID);
        blogMapper.insert(blog);

        return blog;
    }

    @Override
    public Blog selectById(Long id) {
        return blogMapper.selectById(id);
    }
}
