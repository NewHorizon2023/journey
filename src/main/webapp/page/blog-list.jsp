<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Blog List - Journey</title>
    <link rel="icon" href="../img/leaf-3.png" type="image/png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
    <!-- Bootstrap Icons CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@5.0.0/font/bootstrap-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/blog-list.css">
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/booking">Airbnb Booking</a>
                </li>
                <li class="nav-item"> <!-- Keep Airbnb Booking as active -->
                    <a class="nav-link active" href="${pageContext.request.contextPath}/blog/list">Blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/qa">Q&A</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Admin</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Blog Posts Section -->
<div id="blog-posts" class="container">
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
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>

<script src="../js/blog-list.js"></script>
</body>
</html>