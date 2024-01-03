<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Q&A - Journey</title>
    <link rel="icon" href="../img/leaf-3.png" type="image/png">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/qa.css">
</head>
<body>

<!-- Navigation Bar -->
<%@ include file="common-nav.jsp" %>

<!-- Q&A Container -->
<div id="qa-container" class="container">
    <!-- Question Input -->
    <div class="input-group mb-3" id="question-input">
        <input id="question-text" type="text" class="form-control" placeholder="Ask a question..." aria-label="Ask a question..."
               aria-describedby="ask-button">
        <button class="btn btn-primary" type="button" id="ask-button">Ask</button>
    </div>

    <!-- Answer Container -->
    <div id="answer-container">
        <!-- Answers will be dynamically added here using JavaScript -->
    </div>
</div>

<!-- jQuery -->
<script src="../js/jQuery.js"></script>
<!-- Bootstrap JS -->
<script src="../js/bootstrap.js"></script>

<!-- Your additional JavaScript for handling questions and answers -->
<script src="../js/qa.js"></script>
</body>
</html>

