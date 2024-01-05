$(document).ready(function () {
    // Add Blog button click event
    $('#blog-submit').on('click', function () {
        let $blotTitle = $('#blogTitle');
        const blog = {
            id: $blotTitle.attr("blogId"),
            title: $blotTitle.val(),
            content: $('#blogBody').val()
        }

        let url = blog.id ? window.location.origin + '/blog/update' : window.location.origin + '/blog/submit';

        $.ajax({
            type: 'POST',
            url: url,
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