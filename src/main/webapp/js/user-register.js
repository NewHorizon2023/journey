$(document).ready(function () {
	$('#user-register').click(function(){
		// Retrieve form values
        const username = $("#username").val();
        const password = $("#password").val();
        const confirmPassword = $("#confirmPassword").val();

        // Check if required fields are empty
        if (username === '' || password === '' || confirmPassword === '') {
            $("#registration-message").text("Please fill in all required fields.");
        } else if (password !== confirmPassword) {
            $("#registration-message").text("The passwords entered twice are inconsistent, please check.");
        } else {
            // Perform additional validation or submit the form as needed
            // For simplicity, just clear the message and submit the form in this example
            $("#registration-message").text("");
            $("#registration-form").submit();
        }
	});
});