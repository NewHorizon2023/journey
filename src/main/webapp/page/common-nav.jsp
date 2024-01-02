<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link <%= request.getRequestURI().endsWith("index.jsp") ? "active" : "" %>"
                       href="${pageContext.request.contextPath}/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= request.getRequestURI().endsWith("booking.jsp") ? "active" : "" %>"
                       href="${pageContext.request.contextPath}/booking">Airbnb Booking</a>
                </li>
                <li class="nav-item"> <!-- Keep Airbnb Booking as active -->
                    <a class="nav-link <%= request.getRequestURI().contains("blog") ? "active" : "" %>"
                       href="${pageContext.request.contextPath}/blog/list">Blog</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= request.getRequestURI().endsWith("qa.jsp") ? "active" : "" %>"
                       href="${pageContext.request.contextPath}/qa">Q&A</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link <%= request.getRequestURI().contains("admin") ? "active" : "" %>"
                       href="${pageContext.request.contextPath}/admin/login">Admin</a>
                </li>
            </ul>
        </div>
    </div>
</nav>