<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Blog Detail - Journey</title>
    <link rel="icon" href="../img/leaf-3.png" type="image/png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/blog-detail.css">
</head>
<body>

<!-- Navigation Bar -->
<%@ include file="common-nav.jsp" %>

<!-- Blog Post Content -->
<div class="container">
    <div class="blog-post">
        <h2>${blog.title}</h2>
        <p>${blog.content}</p>
        <div class="text-end">
            <c:if test="${not empty user and user.id == blog.authorId}">
                <button class="btn btn-primary">Edit</button>
            </c:if>
            <c:choose>
                <c:when test="${empty user or user.type == 1 and user.id != blog.authorId}">
                </c:when>
                <c:otherwise>
                    <button class="btn btn-danger blog-delete" blogId="${blog.id}" authorId="${blog.authorId}">Delete</button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <!-- Comments Section -->
    <div id="comments" class="comment">
        <h3>Comments</h3>
        <c:forEach var="comment" items="${commentList}">
            <div id="comment-${comment.id}">
                <p><strong>${comment.authorName}:</strong> ${comment.content}</p>
                <div class="text-end">
                    <c:choose>
                        <c:when test="${empty user or user.type == 1 and user.id != blog.authorId}">
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-danger comment-delete" authorId="${comment.authorId}" commentId="${comment.id}"
                                    blogId="${comment.blogId}">Delete
                            </button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Comment Input Form -->
    <div id="comment-form-div" class="mt-4">
        <h3>Add a Comment</h3>
        <form id="comment-form">
            <div class="mb-3">
                <label for="comment-text" class="form-label">Comment:</label>
                <textarea class="form-control" id="comment-text" rows="3"></textarea>
            </div>
            <button id="comment-submit" type="submit" class="btn btn-primary">Submit Comment</button>
        </form>
    </div>
</div>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>

<script src="../js/blog-detail.js"></script>

</body>
</html>
