$(document).ready(function () {
    // Add Blog button click event
    $('#blog-submit').on('click', function () {

        const blog = {
            title: $('#blogTitle').val(),
            content: $('#blogBody').val()
        }
        console.log("url is:");
        console.log(window.location.origin + '/blog/detail?id=');

        $.ajax({
            type: 'POST',
            url: window.location.origin + '/blog/submit',
            data: JSON.stringify(blog),
            dataType: 'json',
            contentType: 'application/json',
            crossDomain: true,  // 如果是跨域请求，可以添加这个选项
            xhrFields: {
                withCredentials: true  // 如果是跨域请求，并且使用了凭据（例如，Cookie），可以添加这个选项
            },
            success: function (response) {
                console.log(response);
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