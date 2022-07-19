$(document).ready(function(){

    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/admins/regReq",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['idKorisnika'] + ">";
                row += "<td>" + data[i]['idKorisnika'] + "</td>";// kreiramo red za tabelu
                row += "<td>" + data[i]['name'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['surname']  + "</td>";
                row += "<td>" + data[i]['emailAddress'] + "</td>";
                row += "<td>" + data[i]['phoneNumber'] + "</td>";
                row += "<td>" + data[i]['regType'] + "</td>";
                row += "<td>" + data[i]['razlog'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#regReq').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
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
        selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
        staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

        $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });

    $("#accept").click(function() {
        var obj = JSON.stringify({
            "idKorisnika" : selektovanRed

        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/admins/acceptRequest",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);

                window.location.href = "AdminPage.html";
                $(selektovanRed).remove();  // radi!!!!

            },
            error: function (data) {
                alert("Greška!");
                console.log("ERROR : ", data);
            }
        });
    });



});