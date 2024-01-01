package ie.nci.journey.controller.dto.request;

/**
 * CommentDto
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2024-01-01
 */
public class CommentDto {
    private Long blogId;
    private Long authorId;
    private Long commentId;

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

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
}
