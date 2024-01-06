<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration - Journey</title>
    <link rel="icon" href="${pageContext.request.contextPath}/../img/leaf-3.png" type="image/png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/../css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/../css/user-register.css">

</head>
<body>

<!-- Navigation Bar -->
<%@ include file="common-nav.jsp" %>

<!-- Registration Form -->
<div class="container mt-5">
    <h2>User Register</h2>
    <div class="container">
        <form id="registration-form" action="${pageContext.request.contextPath}/user/registerSubmit" method="post">
            <div class="form-group required row align-items-center">
                <label for="username" class="col-sm-2 col-form-label">Username:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username" required>
                </div>
            </div>

            <div class="form-group required row align-items-center">
                <label for="password" class="col-sm-2 col-form-label">Password:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
            </div>

            <div class="form-group required row align-items-center">
                <label for="confirmPassword" class="col-sm-2 col-form-label">Confirm Password:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
                </div>
            </div>

            <div class="form-group row align-items-center">
                <label for="email" class="col-sm-2 col-form-label">Email:</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="email" name="email">
                </div>
            </div>

            <div class="form-group row align-items-center">
                <label for="phone" class="col-sm-2 col-form-label">Phone:</label>
                <div class="col-sm-10">
                    <input type="tel" class="form-control" id="phone" name="phone">
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button id="user-register" type="button" class="btn btn-primary">Submit</button>
                </div>
            </div>

            <p id="registration-message">
                <c:if test="${not empty userExisted}">
                    ${userExisted}
                </c:if>
            </p>
        </form>
    </div>
</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/../js/jQuery.js"></script>
<!-- Bootstrap JS -->
<script src="${pageContext.request.contextPath}/../js/bootstrap.js"></script>

<script src="${pageContext.request.contextPath}/../js/user-register.js"></script>

</body>
</html>

