<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Blog List - Journey</title>
    <link rel="icon" href="../img/leaf-3.png" type="image/png">
    <!-- Bootstrap Icons CSS -->
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/blog-list.css">
</head>
<body>

<!-- Navigation Bar -->
<%@ include file="common-nav.jsp" %>

<!-- Blog Posts Section -->
<div id="blog-posts" class="container">
    <h2>Blog List</h2>
    <div class="blog-post">
        <c:forEach var="blog" items="${blogList}">
            <div id="blog-${blog.id}" class="blog-list">
                <p><a href="${pageContext.request.contextPath}/blog/detail?id=${blog.id}">${blog.title}</a></p>
                <c:choose>
                    <c:when test="${empty user or user.type == 1 and user.id != blog.authorId}">
                    </c:when>
                    <c:otherwise>
                        <button class="delete-btn btn btn-danger" blogId="${blog.id}" authorId="${blog.authorId}">Delete
                        </button>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
    </div>

    <!-- Add Blog Button -->
    <button id="add-blog-btn" class="btn btn-primary">Add Blog</button>
</div>

<!-- jQuery -->
<script src="../js/jQuery.js"></script>
<!-- Bootstrap JS -->
<script src="../js/bootstrap.js"></script>

<script src="../js/blog-list.js"></script>
</body>
</html>