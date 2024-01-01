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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css">
    <!-- Custom Styles -->
    <link rel="stylesheet" href="css/index.css">
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/booking">Airbnb Booking</a>
                </li>
                <li class="nav-item"> <!-- Keep Airbnb Booking as active -->
                    <a class="nav-link" href="${pageContext.request.contextPath}/blog/list">Blog</a>
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

<!-- Weather Information -->
<div id="weather">
    <p>Dublin</p>
    <p>Partly cloudy</p>
    <img src="http://cdn.weatherapi.com/weather/64x64/night/116.png" alt="Weather Icon">
    <p>15℃</p>
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

<!-- Bootstrap JS Bundle (Popper.js included) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="js/index.js"></script>
</body>
</html>
