$(document).ready(function(){
    var korisnik = "<tr>";
    korisnik += "<th>" + localStorage.getItem('name') + "</th>";
    korisnik += "<th>" + localStorage.getItem('surname') + "</th>";
    korisnik += "<th>" + localStorage.getItem('phoneNumber') + "</th>";
    korisnik += "<th>" + localStorage.getItem('homeAddress') + "</th>";
    korisnik += "<th>" + localStorage.getItem('city') + "</th>";
    korisnik += "<th>" + localStorage.getItem('state') + "</th>";
    korisnik += "<th>" + localStorage.getItem('emailAddress') + "</th>";
    korisnik += "<th>" + localStorage.getItem('username') + "</th>";
    korisnik += "</tr>";
    $('#regReq').append(korisnik);
});

let selektovanRed = 0;
let staraBoja = null;
$("#regReq").on('click', 'tr:not(:first-child)', function() {
    if (staraBoja != null) {
        $('#regReq tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
    }
    selektovanRed = this.dataset.username;// cuvamo id selektovanog termina
    broj = selektovanRed;
    staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

    $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
    console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
});

$("#change").click(function() {
    var name = $("#name").val();
    var surname = $("#surname").val();
    var homeAddress = $("#homeAddress").val();
    var emailAddress = $("#emailAddress").val();
    var password = $("#password").val();
    var city = $("#city").val();
    var state = $("#state").val();
    var username = selektovanRed;
    var phoneNumber = $("#phoneNumber").val();
    var obj = JSON.stringify({
        "name" : name,
        "surname" : surname,
        "homeAddress" : homeAddress,
        "emailAddress" : emailAddress,
        "password" : password,
        "city" : city,
        "state" : state,
        "username" : username,
        "phoneNumber" : phoneNumber

    });
    $.ajax({
        type: "POST",
        url: "http://localhost:8181/api/korisnik/update",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function (data) {
            console.log("SUCCESS : ", data);
            window.location.href = "index.html";
        },
        error: function (data) {
            alert("Nova greska!");
        }
    });
});