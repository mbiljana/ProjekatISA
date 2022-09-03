$(document).ready(function() {
    var korisnik = localStorage.getItem('id');
    var obj = JSON.stringify({
        "idKorisnika" : korisnik
    });

    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/user/all",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                //row += "<td>" + data[i]['id'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['name'] + "</td>";
                row += "<td>" + data[i]['surname'] + "</td>";
                row += "<td>" + data[i]['username'] + "</td>";
                row += "<td>" + data[i]['emailAddress'] + "</td>";
                row += "<td>" + data[i]['phoneNumber'] + "</td>";
                row += "<td>" + data[i]['password'] + "</td>";
                row += "<td>" + data[i]['role'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#lista').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });

});

