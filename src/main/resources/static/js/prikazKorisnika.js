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
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['id'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['name'] + "</td>";
                row += "<td>" + data[i]['surname'] + "</td>";
                row += "<td>" + data[i]['username'] + "</td>";
                row += "<td>" + data[i]['emailAddress'] + "</td>";
                row += "<td>" + data[i]['phoneNumber'] + "</td>";
                row += "<td>" + data[i]['password'] + "</td>";
                row += "<td>" + data[i]['role'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#listaKorisnika1').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });
    let selektovanRed = 0;
    let staraBoja = null;
    $("#listaKorisnika1").on('click', 'tr:not(:first-child)', function() {
        if (staraBoja != null) {
            $('#listaKorisnika1 tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja);
        }
        selektovanRed = this.dataset.id;
        staraBoja = $(this).css('background-color');

        $(this).css('background-color', '#a6c9e2');
        console.log("Selektovan red ", selektovanRed);

    });



        $("#izmeni").click(function () {
                var korisnik = localStorage.getItem('id');
                var admin = selektovanRed;
                var role = $("#role").val();
                var obj = JSON.stringify({
                    "id": korisnik,
                    "idTermina": admin,
                    "role": role

                });

            $.ajax({
                type: "POST",
                url: "http://localhost:8181/api/admins/updateKorisnik",
                dataType: "json",
                contentType: "application/json",
                data: obj,
                success: function (data) {
                    console.log("SUCCESS : ", data);
                    window.location.href = "AdminPage.html";
                },
                error: function (data) {
                    alert("Nova greska!");
                }
            });
        });


});