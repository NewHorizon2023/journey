$(document).ready(function () {
    // Add comment button click event
    $('#comment-submit').on('click', function () {
        if ($('#comment-text').val()) {
            $('#comment-form').submit();
        }
    });

    // Delete comment button click event
    $('#comment-delete').on('click', function () {
        const commentDto = {
            blogId: this.blogId,
            authorId: this.authorId,
            commentId: this.commentId
        }

        $.ajax({
            type: 'POST',
            url: window.location.origin + '/comment/delete',
            data: JSON.stringify(commentDto),
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                $(this).remove();
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    });
});

