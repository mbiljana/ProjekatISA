$(document).ready(function(){

    const kord = new Array();
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/cottages/all",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere
            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['cottageName'] + "</td>";
                row += "<td>" + data[i]['cottageAddress'] + "</td>";
                row += "<td>" + data[i]['cottageDescription'] + "</td>";
                row += "<td>" + data[i]['srednjaOcena'] + "</td>";
                row += "</tr>";
                $('#regReq').append(row);
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
        selektovanRed = this.dataset.id;
        localStorage.setItem('cottage',this.dataset.id);
        window.location.href = "viewCottage.html";
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });


});
