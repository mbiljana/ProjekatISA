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


        $("#remove").click(function() {
            var obj = localStorage.getItem('id');

            $.ajax({
                type: "POST",
                url: "http://localhost:8181/api/korisnik/removeAccountBoat/" + localStorage.getItem('id'),
                dataType: "json",
                contentType: "application/json",
                data: obj,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                    window.location.href = "home.html";
                },
                error: function (data) {
                    alert("Nova greska!");
                }
            });
        });






    } else
    if(localStorage.getItem('role') == "COTTAGEOWNER"){
        $("#boatOwnerFunc").css('display', 'none');
        $("#cottageOwnerFunc").css('display', 'block');
        $("#adminFunc").css('display', 'none');


        $("#removeC").click(function() {
            var obj = localStorage.getItem('id');

            $.ajax({
                type: "POST",
                url: "http://localhost:8181/api/korisnik/removeAccountCott/" + localStorage.getItem('id'),
                dataType: "json",
                contentType: "application/json",
                data: obj,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                    window.location.href = "home.html";
                },
                error: function (data) {
                    alert("Nova greska!");
                }
            });
        });
    }
    else{
        $("#boatOwnerFunc").css('display', 'none');
        $("#cottageOwnerFunc").css('display', 'none');
        $("#adminFunc").css('display', 'block');
    }

});
