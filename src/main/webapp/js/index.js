$(document).ready(function () {
    // Get weather information
    weather();

    // click logout functionality
    $('#logout-btn').click(function () {
        window.location.href = window.location.origin + '/user/logout';
    });

    // Number of leaves to create
    for (let i = 0; i < 10; i++) {
        createLeaf();
    }

});

const leavesContainer = $('.falling-leaves');

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

/**
 * Get weather information of current location
 */
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
