$(document).ready(function () {
    // Add Blog button click event
    $('#add-blog-btn').on('click', function () {
        window.location.href = window.location.origin + '/blog/editor';
    });
});