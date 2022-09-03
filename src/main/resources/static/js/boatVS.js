$(document).ready(function() {
    var monthlyVisits;
    var yearlyVisits;
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/visits/seasonal",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);
            monthlyVisits = data['monthlyVisits'];
            yearlyVisits = data['yearlyVisits'];
            console.log(monthlyVisits,yearlyVisits);
            var xValues = ['','This month','This year'];
            var xVals =  [0,monthlyVisits, yearlyVisits];
            var myChart = new Chart("myChart", {
                type: "bar",
                data: {labels: xValues,
                    datasets: [{
                        data: xVals
                    }]},
                options: {
                    text: "Visits"
                }
            });
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });



});
