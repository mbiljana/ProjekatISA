$(document).ready(function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/cottages",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['cottageName'] + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + data[i]['cottageAddress']  + "</td>";
                row += "<td>" + data[i]['cottageDescription'] + "</td>";
                row += "<td>" + data[i]['numRooms'] + "</td>";
                row += "<td>" + data[i]['numBeds']  + "</td>";
                row += "<td>" + data[i]['cottageAdditionalServices'] + "</td>";
                row += "<td>" + data[i]['cottageRules'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#cottages').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }
    });

});