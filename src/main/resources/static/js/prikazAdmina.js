$(document).ready(function() {


    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/admins/allKorisnici",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
       //         row += "<td>" + data[i]['id'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['name'] + "</td>";
                row += "<td>" + data[i]['surname'] + "</td>";
                row += "<td>" + data[i]['username'] + "</td>";
       //         row += "<td>" + data[i]['birthDate'] + "</td>";
                row += "<td>" + data[i]['emailAddress'] + "</td>";
                row += "<td>" + data[i]['phoneNumber'] + "</td>";
                row += "<td>" + data[i]['homeAddress'] + "</td>";
                row += "<td>" + data[i]['city'] + "</td>";
                row += "<td>" + data[i]['role'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#adminIzmene').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });

});