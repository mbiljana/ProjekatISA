$(document).ready(function(){

    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/reservations/allCottage",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere
            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['resName'] + "</td>";
                row += "<td>" + data[i]['startDate'] + "</td>";
                row += "<td>" + data[i]['income'] + "</td>";
                row += "</tr>";
                $('#regReq').append(row);
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });

    $("#send").click(function() {
        var report = $("#report").val();
        var obj = JSON.stringify({
            "report" : report
        });
        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/korisnik/report",
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