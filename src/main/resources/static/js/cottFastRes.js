$(document).ready(function(){
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
                row += "<td>" + data[i]['numRooms'] + "</td>";
                row += "<td>" + data[i]['numBeds'] + "</td>";
                row += "<td>" + data[i]['cottageAdditionalServices'] + "</td>";
                row += "<td>" + data[i]['cottageRules'] + "</td>";
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
        var cottId = selektovanRed;
        var startDate = $("#startDate").val();
        var duration = $("#duration").val();
        var additionalServices = $("#additionalServices").val();
        var obj = JSON.stringify({
            "cottId" : cottId,
            "startDate" : startDate,
            "duration" : duration,
            "additionalServices" : additionalServices

        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/cottages/createResCott",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "cottagesPage.html";
            },
            error: function (data) {
                alert("Nova greska!");
            }
        });
    });

});