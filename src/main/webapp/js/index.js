$(document).ready(function () {
        const leavesContainer = $('.falling-leaves');
		const loginContainer = $('#login');
		const userWelcomeContainer = $('#user-welcome');
		const welcomeMessage = $('#welcome-message');
		const loginBtn = $('#login-btn');
		const logoutBtn = $('#logout-btn');

		// Assume a successful login triggers this function
		function onLoginSuccess(username) {
			// Hide login form
			loginContainer.hide();

			// Show user welcome information
			userWelcomeContainer.show();
			welcomeMessage.text('Hello, ' + username);

			// Implement logout functionality
			logoutBtn.click(function () {
				// Perform logout actions (e.g., invalidate session)
				// ...

				// Show login form again and hide user welcome information
				loginContainer.show();
				userWelcomeContainer.hide();
			});
		}
		
		loginBtn.click(function(event){
			event.preventDefault();
			
			onLoginSuccess("tom");
		});

		// Number of leaves to create
		const numLeaves = 10;

		for (let i = 0; i < numLeaves; i++) {
			createLeaf();
		}

		function createLeaf() {
			const leaf = $('<div>').addClass('leaf');
			leaf.css({
				top: `${Math.random() * 100}vh`, // Random vertical position
				left: `${Math.random() * 100}vw`, // Random horizontal position
				'--speed': `${Math.random() * 5}s`, // Random speed
			});
			leavesContainer.append(leaf);
		}
    });