$(document).ready(function(){

    $("#addOwnerForm").submit(function(event) {

        event.preventDefault();
        var username = $("#username").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();
        var name = $("#name").val();
        var surname = $("#surname").val();
        var phoneNumber = $("#phoneNumber").val();
        var emailAddress = $("#emailAddress").val();
        var birthDate = $("#birthDate").val();
        var city = $("#city").val();
        var state = $("#state").val();
        var homeAddress = $("#homeAddress").val();
        var regType = $("#regType").val();
        //var aktivan = true;
       // var da_li_je_registrovan = true;
        var obj = JSON.stringify({
            "username" : username,
            "password" : password,
            "password2" : password2,
            "name" : name,
            "surname" : surname,
            "phoneNumber" : phoneNumber,
            "emailAddress" : emailAddress,
            "birthDate" : birthDate,
            "city" : city,
            "state" : state,
            "homeAddress" : homeAddress ,
            "regType" : regType,
            "role" : 1,
           // "aktivan" : aktivan,
           // "da_li_je_registrovan" : da_li_je_registrovan,
        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/korisnik/registerOwner",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function () {
                alert(obj);
                window.location.href = "index.html";
            },
            error: function (data) {
                alert("Da li se poruka prenela?");
                alert(data);
                alert("Izgleda da jeste");
            }
        });

        /*
            });
            $.ajax({
                type: "GET",
                url: "http://localhost:8181/api/korisnik/zahteviZaRegistracijuClana",
                dataType: "json",
                success: function (response) {
                    console.log("SUCCESS:\n", response);
                    for (let trener of response) {
                        let row = "<tr>";
                        row += "<td>" + trener.ime + "</td>";
                        row += "<td>" + trener.prezime + "</td>";
                        row += "<td>" + trener.email + "</td>";
                        row += "<td>" + trener.telefon + "</td>";
                        row += "</tr>";
                        $('#zahteviZaRegistracijuClana').append(row);
                    }
                },
                error: function (response) {
                } */
    });


});