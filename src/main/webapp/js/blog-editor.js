$(document).ready(function () {
    // Add Blog button click event
    $('#blog-submit').on('click', function () {
        const blog = {
            title: $('#blogTitle').val(),
            content: $('#blogBody').val()
        }

        $.ajax({
            type: 'POST',
            url: window.location.origin + '/blog/submit',
            data: JSON.stringify(blog),
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                if (response.status === 200) {
                    window.location.href = window.location.origin + '/blog/detail?id=' + response.data.id;
                } else {
                    window.location.href = window.location.origin + '/';
                }
            },
            error: function (error) {
                console.log("error info:");
                console.log(error);
            }
        });
    });
});