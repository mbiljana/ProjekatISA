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



    $("#change").click(function() {
        var id = selektovanRed;
        var boatName = $("#boatName").val();
        var boatType = $("#boatType").val();
        var engineNumber = $("#engineNumber").val();
        var enginePower = $("#enginePower").val();
        var maxSpeed = $("#maxSpeed").val();
        var boatAddress = $("#boatAddress").val();
        var boatCapacity = $("#boatCapacity").val();
        var boatRules = $("#boatRules").val();
        var boatDescription = $("#boatDescription").val();
        var additionalEquipment = $("#additionalEquipment").val();
        var navigationEguipment = $("#navigationEguipment").val();
        var obj = JSON.stringify({
            "id" : id,
            "boatName" : boatName,
            "boatType" : boatType,
            "engineNumber" : engineNumber,
            "enginePower" : enginePower,
            "maxSpeed" : maxSpeed,
            "boatAddress" : boatAddress,
            "boatCapacity" : boatCapacity,
            "boatRules" : boatRules,
            "boatDescription" : boatDescription,
            "additionalEquipment" : additionalEquipment,
            "navigationEguipment" : navigationEguipment

        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/boats/update",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "boatPage.html";
            },
            error: function (data) {
                alert("Nova greska!");
            }
        });
    });

    $("#delete").click(function() {
        var obj = JSON.stringify({
            "idKorisnika" : selektovanRed

        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/boats/remove",
            dataType: "json",
            contentType: "application/json",
            data: obj,
            success: function (data) {
                console.log("SUCCESS : ", data);
                window.location.href = "boatPage.html";

            },
            error: function (data) {
                alert("Greška!");
                console.log("ERROR : ", data);
            }
        });
    });

});