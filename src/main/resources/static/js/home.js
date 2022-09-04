$(document).ready(function(){
    console.log(localStorage.getItem('username'));
    if(localStorage.getItem('username') === null || localStorage.getItem('username') == 'none'){
        $("#boatOwnerFunc").css('display', 'none');
        $("#cottageOwnerFunc").css('display', 'none');
        $("#adminFunc").css('display', 'none');

    } else
    if(localStorage.getItem('role') == "BOATOWNER") {
        $("#boatOwnerFunc").css('display', 'block');
        $("#cottageOwnerFunc").css('display', 'none');
        $("#adminFunc").css('display', 'none');
    } else
    if(localStorage.getItem('role') == "COTTAGEOWNER"){
        $("#boatOwnerFunc").css('display', 'none');
        $("#cottageOwnerFunc").css('display', 'block');
        $("#adminFunc").css('display', 'none');
    }
    else{
        $("#boatOwnerFunc").css('display', 'none');
        $("#cottageOwnerFunc").css('display', 'none');
        $("#adminFunc").css('display', 'block');
    }

});
