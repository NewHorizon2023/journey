$(document).ready(function () {
    // Get weather infomation
    weather();

    // click logout functionality
    logoutBtn.click(function () {
        window.location.href = window.location.origin + '/user/logout';
        // Show login form again and hide user welcome information
        /*loginContainer.show();
        userWelcomeContainer.hide();*/
    });

    // Number of leaves to create
    const numLeaves = 10;
    for (let i = 0; i < numLeaves; i++) {
        createLeaf();
    }

});


const leavesContainer = $('.falling-leaves');
const loginContainer = $('#login');
const userWelcomeContainer = $('#user-welcome');
const welcomeMessage = $('#welcome-message');
const loginBtn = $('#login-btn');
const logoutBtn = $('#logout-btn');

/**
 * successful login triggers function
 * @param username
 */
function onLoginSuccess(username) {
    // Hide login form
    loginContainer.hide();

    // Show user welcome information
    userWelcomeContainer.show();
    welcomeMessage.text('Hello, ' + username);

}

/**
 * create leaves
 */
function createLeaf() {
    const leaf = $('<div>').addClass('leaf');
    leaf.css({
        top: `${Math.random() * 100}vh`, // Random vertical position
        left: `${Math.random() * 100}vw`, // Random horizontal position
        '--speed': `${Math.random() * 5}s`, // Random speed
    });
    leavesContainer.append(leaf);
}

function weather() {
    // Get current latitude and longitude
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            // Get weather information
            $.ajax({
                type: 'GET',
                url: window.location.origin + '/api/weather',
                data: {location: position.coords.latitude + ',' + position.coords.longitude},
                dataType: 'json',
                contentType: 'application/json',
                success: function (response) {
                    $('#city-name').text(response.data.location.name);
                    $('#weather-info').text(response.data.current.condition.text);
                    $('#weather-img').attr('src', 'http:' + response.data.current.condition.icon);
                    $('#temperature').text(response.data.current.temp_c + '℃');
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }, function (error) {
            console.error('Geolocation error:', error);
        });
    } else {
        console.error('Geolocation is not supported by this browser.');
    }

}
