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

$.ajax({
    type: "GET",
    url: "http://localhost:8181/api/korisnik/" + localStorage.getItem('username'),
    dataType: "json",
    success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
        console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere
            var row = "<tr data-id=" + data['id'] + ">";                                  // kreiramo red za tabelu
            row += "<td>" + data['name'] + "</td>";
            row += "<td>" + data['surname'] + "</td>";
            row += "<td>" + data['phoneNumber'] + "</td>";
            row += "<td>" + data['homeAddress'] + "</td>";
            row += "<td>" + data['city'] + "</td>";
            row += "<td>" + data['state'] + "</td>";
            row += "<td>" + data['emailAddress'] + "</td>";
            row += "<td>" + data['username'] + "</td>";
            row += "</tr>";
            $('#regReq').append(row);
    },
    error: function (response) {
        alert("Dogodila se greska, pogledaj konzolu");
        console.log("ERROR : ", data);

    }

});

let selektovanRed = 0;
let staraBoja = null;
$("#regReq").on('click', 'tr:not(:first-child)', function() {
    if (staraBoja != null) {
        $('#regReq tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
    }
    selektovanRed = localStorage.getItem('username');// cuvamo id selektovanog termina

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
});
