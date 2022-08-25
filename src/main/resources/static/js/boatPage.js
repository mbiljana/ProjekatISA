$(document).ready(function(){

    const kord = new Array();
    var cnt = 0;
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/boats/all",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['boatName'] + "</td>";
                row += "<td>" + data[i]['boatType'] + "</td>";
                row += "<td>" + data[i]['boatDescription'] + "</td>";
                row += "<td>" + data[i]['srednjaOcena'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda
                kord.push(data[i]['latitude'],data[i]['longitude']);
                cnt = cnt+1;
                $('#regReq').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });
    let selektovanRed = 0;
    //let staraBoja = null;
    $("#regReq").on('click', 'tr:not(:first-child)', function() {
        selektovanRed = this.dataset.id;
        localStorage.setItem('boat',this.dataset.id);
        window.location.href = "viewBoat.html";
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });



});
