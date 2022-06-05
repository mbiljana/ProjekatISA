$(document).ready(function() {
    if (localStorage.getItem('username') === null || localStorage.getItem('username') == 'none') {
        $("#boatOwnerFunc").css('display', 'none');
        $("#cottageOwnerFunc").css('display', 'none');
        $("#adminFunc").css('display', 'none');

    } else if (localStorage.getItem('role') == "ADMIN") {
        $("#boatOwnerFunc").css('display', 'none');
        $("#cottageOwnerFunc").css('display', 'none');
        $("#adminFunc").css('display', 'block');
        window.location.href = "secondPage.html";
    }
});