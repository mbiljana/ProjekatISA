$(document).ready(function(){
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
                row += "<td>" + data[i]['boatAddress'] + "</td>";
                row += "<td>" + data[i]['boatRules'] + "</td>";
                row += "<td>" + data[i]['boatDescription'] + "</td>";
                row += "<td>" + data[i]['additionalEquipment'] + "</td>";
                row += "<td>" + data[i]['navigationEguipment'] + "</td>";
                row += "<td>" + data[i]['srednjaOcena'] + "</td>";
                row += "</tr>";                                     // završavamo kreiranje reda


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
        if (staraBoja != null) {
            $('#regReq tr[data-id=' + selektovanRed + ']').css('background-color', staraBoja); // vracamo staru boju
        }
        selektovanRed = this.dataset.id;// cuvamo id selektovanog termina
        broj = selektovanRed;
        staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

        $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });



    $("#res").click(function() {
        var boatId = selektovanRed;
        var resName = $("#resName").val();
        var startDate = $("#startDate").val();
        var duration = $("#duration").val();
        var additionalServices = $("#additionalServices").val();
        var price = $("#price").val();
        var obj = JSON.stringify({
            "boatId" : boatId,
            "resName" : resName,
            "startDate" : startDate,
            "duration" : duration,
            "additionalServices" : additionalServices,
            "price" : price

        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/boats/createRes",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "viewBoatReservations.html";
            },
            error: function (data) {
                alert("Nova greska!");
            }
        });
    });

});
