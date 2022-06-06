$(document).ready(function(){

    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/reservations/allBoat",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere
            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['resName'] + "</td>";
                row += "<td>" + data[i]['startDate'] + "</td>";
                row += "<td>" + data[i]['income'] + "</td>";
                row += "<td>" + data[i]['numPeople'] + "</td>";
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
                window.location.href = "boatPage.html";
            },
            error: function (data) {
                alert("Nova greska!");
            }
        });

    });

    var xValues = ['Boat1'];
    var yValues = [2500];

    var barColors = [
        "rgba(0,0,255,1.0)",
        "rgba(0,0,255,0.8)",
        "rgba(0,0,255,0.6)",
        "rgba(0,0,255,0.4)",
        "rgba(0,0,255,0.2)",
    ];

    var myChart = new Chart("myChart", {
        type: "bar",
        data: {labels: xValues,
            datasets: [{
                backgroundColor: barColors,
                data: yValues
            }]},
        options: {}
    });


});