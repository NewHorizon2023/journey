<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Registration - Journey</title>
    <link rel="icon" href="../img/leaf-3.png" type="image/png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/admin-login.css">

</head>
<body>

<!-- Navigation Bar -->
<%@ include file="common-nav.jsp" %>

<!-- Registration Form -->
<div class="container mt-5">
    <h2>Admin Login</h2>
    <div class="container">
        <form id="login-form" action="${pageContext.request.contextPath}/admin/loginSubmit" method="post">
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

            <div class="form-group row">
                <div class="col-sm-10 offset-sm-2">
                    <button id="user-register" type="submit" class="btn btn-primary">Login</button>
                </div>
            </div>

            <c:if test="${not empty sessionScope.adminLoginFail}">
                <p id="registration-message">Admin account or password is wrong, please try again.</p>
                <% request.getSession().removeAttribute("adminLoginFail"); %>
            </c:if>
        </form>

        <p class="mt-2">No account? <a href="${pageContext.request.contextPath}/admin/register">Click Here to
            Register</a></p>
    </div>
</div>

<!-- jQuery -->
<script src="../js/jQuery.js"></script>
<!-- Bootstrap JS -->
<script src="../js/bootstrap.js"></script>


</body>
</html>
