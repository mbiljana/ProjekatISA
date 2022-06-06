$(document).ready(function(){
    const names = [];
    const incomes = [];
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
                row += "<td>" + data[i]['numPeople'] + "</td>";
                row += "</tr>";
                names.push(data[i]['resName']);
                incomes.push(data[i]['income']);
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

    var xValues = ['Cottage1','Cottage2'];
    var yValues = [200,160];
    var xVals = ['2022-12-09','2022-12-10'];
    var yVals = [5,4];

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
        options: {
            text: "Income"
        }
    });


    var newChart = new Chart("newChart", {
        type: "pie",
        data: {labels: xVals,
            datasets: [{
                backgroundColor: barColors,
                data: yVals
            }]},
        options: {
            text: "Income"
        }
    });








});