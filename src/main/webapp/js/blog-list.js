$(document).ready(function () {
    // Add Blog button click event
    $('#add-blog-btn').on('click', function () {
        window.location.href = window.location.origin + '/blog/editor';
    });

    // Delete Blog button click event
    $('.delete-btn').on('click', function () {
        const blogDto = {
            blogId: $(this).attr('blogId'),
            authorId: $(this).attr('authorId')
        }

        $.ajax({
            type: 'POST',
            url: window.location.origin + '/blog/delete',
            data: JSON.stringify(blogDto),
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                $('#blog-' + response.data.blogId).remove();
            },
            error: function (error) {
                console.log(error);
            }
        });
    });
});