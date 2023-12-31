$(document).ready(function () {
    // Submit by click
    $('#ask-button').on('click', function () {
        addAnswer();
    });

    // Submit by pressing enter key
    $('#question-text').on('keyup', function (e) {
        if (e.keyCode === 13) {
            addAnswer();
        }
    });
});

// Function to add a new answer to the answer container
function addAnswer() {
    const question = {
        messages: [
            {
                role: "user",
                content: $('#question-input input').val()
            }
        ]
    };

    // waiting icon
    $('#answer-container').html('<div class="loading-spinner"></div>');

    $.ajax({
        type: 'POST',
        url: window.location.origin + '/api/ai',
        data: JSON.stringify(question),
        dataType: 'json',
        contentType: 'application/json',
        success: function (response) {
            $('#answer-container').html('<p>' + response.data.text.replace(/\n\n/g, '</p><p>').replace(/\n/g, '<br>') + '</p>');
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
}
