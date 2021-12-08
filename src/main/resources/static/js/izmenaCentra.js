$(document).ready(function(){
    var korisnik = localStorage.getItem('id');
    var obj = JSON.stringify({
        "idKorisnika" : korisnik
    });


    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/admins/allKorisnici",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['name'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['surname']  + "</td>";
                row += "<td>" + data[i]['username']  + "</td>";
                row += "<td>" + data[i]['role']  + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#centri').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });


    let selektovanRed = 0;
    let staraBoja = null;
    $("#centri").on('click', 'tr:not(:first-child)', function() {
        if (staraBoja != null) {
            $('#centri tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja);
        }
        selektovanRed = this.dataset.id;
        staraBoja = $(this).css('background-color');

        $(this).css('background-color', '#a6c9e2');
        console.log("Selektovan red ", selektovanRed);
    });

    $("#izmeni").click(function() {
        var korisnik = localStorage.getItem('id');
        var centar = selektovanRed;
        var nazivCentra = $("#nazivCentra").val();
        var adresaCentra = $("#adresaCentra").val();
        var brojTelefonaCentrale = $("#brojTelefonaCentrale").val();
        var emailCentra = $("#emailCentra").val();
        var obj = JSON.stringify({
            "idKorisnika" : korisnik,
            "idTermina" : centar,
            "nazivCentra" : nazivCentra,
            "adresaCentra" : adresaCentra,
            "brojTelefonaCentrale" : brojTelefonaCentrale,
            "emailCentra" : emailCentra

        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/sviFitnesCentri/izmena",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "izmenaCentra.html";
            },
            error: function (data) {
                alert("Nova greska!");
            }
        });
    });

});