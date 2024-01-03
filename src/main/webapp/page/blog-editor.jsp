<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Blog Edit - Journey</title>
    <link rel="icon" href="../img/leaf-3.png" type="image/png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/blog-editor.css">
</head>
<body>

<!-- Navigation Bar -->
<%@ include file="common-nav.jsp" %>

<!-- Blog Content -->
<div class="blog-container">
    <div class="blog-title">
        <label for="blogTitle">Blog Title:</label>
        <input type="text" id="blogTitle" class="form-control" placeholder="Enter your blog title">
    </div>

    <div class="blog-body">
        <label for="blogBody">Blog Body:</label>
        <textarea id="blogBody" class="form-control" placeholder="Write your blog content here"></textarea>
    </div>

    <!-- Additional styling for the submit button -->
    <button id="blog-submit" class="btn btn-primary mt-3">Publish Blog</button>
</div>

<!-- jQuery -->
<script src="../js/jQuery.js"></script>
<!-- Bootstrap JS -->
<script src="../js/bootstrap.js"></script>

<script src="../js/blog-editor.js"></script>

</body>
</html>

