<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Journey</title>
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
                    <a class="nav-link" href="#">Airbnb Booking</a>
                </li>
                <li class="nav-item"> <!-- Keep Airbnb Booking as active -->
                    <a class="nav-link" href="#">Blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Q&A</a>
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

<!-- Login Module -->
<div id="login">
    <form>
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password">
        </div>
        <button id="login-btn" type="submit" class="btn btn-primary">Login</button>
    </form>
    <p class="mt-2">No account? <a href="${pageContext.request.contextPath}/user/register">Register</a></p>
</div>

<!-- User Welcome Section -->
<div id="user-welcome" style="display: none;">
    <p id="welcome-message"></p>
    <button id="logout-btn" class="btn btn-danger">Logout</button>
</div>

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
