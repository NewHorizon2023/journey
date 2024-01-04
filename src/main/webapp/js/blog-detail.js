$(document).ready(function () {
    $('.blog-delete').on('click', function () {
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
                window.location.href = window.location.origin + '/blog/list';
            },
            error: function (error) {
                console.log(error);
            }
        });
    });

    $('#edit-btn').on('click', function (){
        window.location.href = window.location.origin + '/blog/editor?id=' + $(this).val();
    });

    // Add comment button click event
    $('#comment-form').submit(function (event) {
        event.preventDefault();
        //action="${pageContext.request.contextPath}/comment/submit" method="post"
        const contentText = $('#comment-text').val();
        if (!contentText) {
            alert('Comment cannot be empty!')
        }

        // 获取当前页面的URL
        const url = new URL(window.location.href);
        const blogId = url.searchParams.get('id');

        const comment = {
            content: contentText,
            blogId: blogId
        }

        $.ajax({
            type: 'POST',
            url: window.location.origin + '/comment/submit',
            data: JSON.stringify(comment),
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                const newCommentDiv = '<div><p><strong>' + response.data.authorName + ':</strong>' + contentText + '</p><div class="text-end"><button class="btn btn-danger comment-delete" authorId="' + response.data.authorId + '" commentId="' + response.data.id + '" blogId="' +
                    response.data.blogId + '">Delete</button></div></div>';

                // Append new comment to the end of the container
                $('#comments').append(newCommentDiv);
                $('#comment-text').val('');
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });

    });

    let commentDto;
    // Delete comment button click event
    $('.comment-delete').on('click', function () {
        commentDto = {
            blogId: $(this).attr('blogId'),
            authorId: $(this).attr('authorId'),
            commentId: $(this).attr('commentId')
        }

        $.ajax({
            type: 'POST',
            url: window.location.origin + '/comment/delete',
            data: JSON.stringify(commentDto),
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                $('#comment-' + commentDto.commentId).remove();
                console.log();
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
    });

});

