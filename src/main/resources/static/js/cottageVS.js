$(document).ready(function() {
    var monthlyVisits;
    var yearlyVisits;
    var weeklyVisits;
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/visits/seasonalCott",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);
            monthlyVisits = data['monthlyVisits'];
            yearlyVisits = data['yearlyVisits'];
            weeklyVisits = data['weeklyVisits'];
            console.log(monthlyVisits,yearlyVisits);
            var barColors = [
                "rgba(0,0,255,1.0)",
                "rgba(0,0,255,0.8)",
                "rgba(0,0,255,0.6)",
                "rgba(0,0,255,0.4)",
                "rgba(0,0,255,0.2)",
            ];
            var xValues = ['','This week','This month','This year'];
            var xVals =  [0,weeklyVisits,monthlyVisits, yearlyVisits];
            var myChart = new Chart("myChart", {
                type: "bar",
                data: {labels: xValues,
                    datasets: [{
                        backgroundColor: barColors,
                        data: xVals
                    }]},
                options: {
                    text: "Visits",
                    legend: {
                        display: true,
                        labels: {
                            fontColor: "#000080",
                        }
                    }
                }
            });
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });



});
