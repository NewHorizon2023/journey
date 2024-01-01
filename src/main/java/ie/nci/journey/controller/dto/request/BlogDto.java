package ie.nci.journey.controller.dto.request;

/**
 * BlogDto
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2024-01-01
 */
public class BlogDto {
    private Long blogId;
    private Long authorId;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
