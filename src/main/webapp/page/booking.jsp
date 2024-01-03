<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Booking - Journey</title>
    <link rel="icon" href="../img/leaf-3.png" type="image/png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../css/bootstrap.css">
    <!-- Custom Styles -->
    <link rel="stylesheet" href="../css/booking.css">
</head>
<body>

<!-- Navigation Bar -->
<%@ include file="common-nav.jsp" %>

<!-- Airbnb Booking Page Content -->
<div class="container">
    <!-- Search Form -->
    <form id="booking-form">
        <div class="row">
            <div class="col-md-2 mb-3">
                <label for="location" class="form-label required-field">Location</label>
                <input type="text" class="form-control" id="location" required>
                <div class="error-message" id="location-error"></div>
            </div>
            <div class="col-md-2 mb-3">
                <label for="checkin" class="form-label required-field">Check-in</label>
                <input type="date" class="form-control" id="checkin" required>
                <div class="error-message" id="checkin-error"></div>
            </div>
            <div class="col-md-2 mb-3">
                <label for="checkout" class="form-label required-field">Check-out</label>
                <input type="date" class="form-control" id="checkout" required>
                <div class="error-message" id="checkout-error"></div>
            </div>
            <div class="col-md-1 mb-3">
                <label for="adults" class="form-label required-field">Adults</label>
                <input type="number" class="form-control" id="adults" required>
                <div class="error-message" id="adults-error"></div>
            </div>
            <div class="col-md-1 mb-3">
                <label for="children" class="form-label">Children</label>
                <input type="number" class="form-control" id="children">
                <div class="error-message" id="children-error"></div>
            </div>
            <div class="col-md-1 mb-3">
                <label for="infants" class="form-label">Infants</label>
                <input type="number" class="form-control" id="infants">
                <div class="error-message" id="infants-error"></div>
            </div>
            <div class="col-md-1 mb-3">
                <label for="pets" class="form-label">Pets</label>
                <input type="number" class="form-control" id="pets">
                <div class="error-message"></div>
            </div>
            <div class="col-md-1 mb-3">
                <label for="currency" class="form-label">Currency</label>
                <select class="form-control" id="currency">
                    <option value="USD">USD</option>
                    <option value="EUR">EUR</option>
                    <option value="RMB">RMB</option>
                    <!-- Add more currency options as needed -->
                </select>
                <div class="error-message" id="currency-error"></div>
            </div>
            <div class="col-md-1 mb-3">
                <label for="pets" class="form-label">Page</label>
                <input type="number" class="form-control" id="page">
                <div class="error-message"></div>
            </div>
        </div>

        <!-- Additional search fields... -->
        <div class="col-md-1 mb-3 ml-auto">
            <button id="airbnbSearch" type="button" class="btn btn-primary">Search</button>
        </div>

    </form>

    <!-- Search Results -->
    <div id="search-results">
        <!-- Results will be dynamically added here using JavaScript -->
    </div>
</div>

<!-- Existing body content... -->

<!-- jQuery -->
<script src="../js/jQuery.js"></script>
<!-- Bootstrap JS -->
<script src="../js/bootstrap.js"></script>
<!-- Additional Script for Airbnb Booking Page -->
<script src="../js/booking.js"></script>
</body>
</html>

