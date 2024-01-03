<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home - Journey</title>
    <link rel="icon" href="img/leaf-3.png" type="image/png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Custom Styles -->
    <link rel="stylesheet" href="css/index.css">
</head>
<body>

<!-- Navigation Bar -->
<%@ include file="page/common-nav.jsp" %>

<!-- Weather Information -->
<div id="weather">
    <p id="city-name"></p>
    <p id="weather-info"></p>
    <img id="weather-img" src="" alt=""/>
    <p id="temperature"></p>
</div>

<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <!-- User Welcome Section -->
        <div id="user-welcome">
            <p id="welcome-message">Hello, ${sessionScope.user.username}</p>
            <button id="logout-btn" class="btn btn-danger">Logout</button>
        </div>
    </c:when>
    <c:otherwise>
        <div id="login">
            <form action="${pageContext.request.contextPath}/user/login" method="post">
                <div class="mb-3">
                    <label for="username" class="form-label">Username</label>
                    <input type="text" class="form-control" id="username" name="username">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" class="form-control" id="password" name="password">
                </div>
                <button id="login-btn" type="submit" class="btn btn-primary">Login</button>
            </form>

            <c:choose>
                <c:when test="${not empty sessionScope.loginFail}">
                    <p id="wrong-name-pwd" class="mt-2">Username or password is wrong, please try again.</p>
                    <% request.getSession().removeAttribute("loginFail"); %>
                </c:when>
                <c:otherwise>
                    <p class="mt-2">No account? <a href="${pageContext.request.contextPath}/user/register">Register</a>
                    </p>
                </c:otherwise>
            </c:choose>
        </div>

    </c:otherwise>
</c:choose>
<!-- Animated Falling Leaves -->
<div class="falling-leaves">
    <!-- Add leaves dynamically using JavaScript -->
</div>
<!-- jQuery -->
<script src="js/jQuery.js"></script>
<!-- Bootstrap JS -->
<script src="js/bootstrap.js"></script>
<script src="js/index.js"></script>
</body>
</html>
