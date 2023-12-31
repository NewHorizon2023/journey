$(document).ready(function () {
    $('#airbnbSearch').click(function () {
        getAirbnbData();
    });
});

// Function to validate the form inputs
function validateForm() {
    let isValid = true;

    // Clear existing error messages
    $(".error-message").text("");

    // Check each required field
    if ($("#location").val() === "") {
        $("#location-error").text("Location is required.");
        isValid = false;
    }
    if ($("#checkin").val() === "") {
        $("#checkin-error").text("Check-in date is required.");
        isValid = false;
    }
    if ($("#checkout").val() === "") {
        $("#checkout-error").text("Check-out date is required.");
        isValid = false;
    }
    if ($("#adults").val() === "") {
        $("#adults-error").text("Number of adults is required.");
        isValid = false;
    }

    return isValid;
}

// Function to create a search result card element
function createResultCard(result) {
    const card = $("<div>").addClass("card mb-3");
    const imagesContainer = $("<div>").addClass("d-flex justify-content-center");

    let limit = Math.min(result.images.length, 5);
    for (let index = 0; index < limit; index++) {
        let imgUrl = result.images[index];
        const thumbnail = $("<img>")
            .attr("src", imgUrl)
            .addClass("img-thumbnail mx-2") // Bootstrap thumbnail and margin
            .css({
                "max-width": "200px", // Set maximum width for thumbnail
                "max-height": "200px", // Set maximum height for thumbnail
                "width": "auto", // Ensure width adjusts to maintain aspect ratio
                "height": "auto" // Ensure height adjusts to maintain aspect ratio
            });
            //.css("max-width", "200px"); // Set maximum width for thumbnail
        imagesContainer.append(thumbnail);
    }

    const cardBody = $("<div>").addClass("card-body");
    const title = $("<h5>").addClass("card-title").text(`${result.city} - ${result.name}`);
    const address = $("<p>").addClass("card-text").text(result.address);
    const price = $("<p>").addClass("card-text").text(`Price: ${result.price.rate} ${result.price.currency}`);
    const link = $("<a>")
        .attr("href", result.url)
        .attr("target", "_blank")
        .text("View Details");

    // Append elements to the card
    cardBody.append(title, address, price, link);
    card.append(imagesContainer, cardBody);

    return card;
}

// Call the function to display search results
function searchAirbnb(searchResultsData) {
    // Check form validation before proceeding
    if (!validateForm()) {
        return;
    }

    if (searchResultsData.error) {
        alert("An unknown exception occurred, please try again later");
    }

    const searchResultsContainer = $("#search-results");

    // Clear existing results
    searchResultsContainer.empty();

    // Create and append result cards
    let i = 0;
    searchResultsData.results.forEach(result => {
        i++;
        const resultCard = createResultCard(result);
        searchResultsContainer.append(resultCard);
    });
}

function getAirbnbData() {
    // add loading spinner
    $('#search-results').html('<div class="loading-spinner"></div>');

    const param = {
        location: $('#location').val(),
        checkin: $('#checkin').val(),
        checkout: $('#checkout').val(),
        adults: $('#adults').val(),
        children: $('#children').val(),
        infants: $('#infants').val(),
        pets: $('#page').val(),
        currency: $('#currency').val()
    };

    $.ajax({
        url: 'https://airbnb13.p.rapidapi.com/search-location',
        method: 'GET',
        data: param,
        dataType: 'json',
        headers: {
            'X-RapidAPI-Key': 'ff4f5cd3a6mshaae92fcc4c9b174p165136jsn644f4d752007',
            'X-RapidAPI-Host': 'airbnb13.p.rapidapi.com'
        },
        success: function (response) {
            searchAirbnb(response);
        },
        error: function (error) {
            alert("An unknown exception occurred, please try again later");
        }
    });
}