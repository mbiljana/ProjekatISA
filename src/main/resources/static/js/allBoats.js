$(document).ready(function(){


    var korisnik = localStorage.getItem('id');
    var obj = JSON.stringify({
        "idKorisnika" : korisnik
    });

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/boats/all",
        dataType: "json",
        contentType: "application/json",
        data: obj,
        success: function (data) {
            console.log("SUCCESS : ", data);

            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";
                row += "<td>" + data[i]['boatName'] + "</td>";
                row += "<td>" + data[i]['boatType'] + "</td>";
                row += "<td>" + data[i]['engineNumber'] + "</td>";
                row += "<td>" + (data[i]['enginePower'].split("T"))[0] + "</td>";
                row += "<td>" + (data[i]['maxSpeed'].split("T"))[0] + "</td>";
                row += "<td>" + data[i]['boatAddress'] + "</td>";
                row += "<td>" + data[i]['boatCapacity'] + "</td>";
                row += "<td>" + data[i]['boatRules'] + "</td>";
                row += "<td>" + data[i]['boatDescription'] + "</td>";
                row += "<td>" + data[i]['additionalEquipment'] + "</td>";

                row += "</tr>";


                $('#boats').append(row);


            }
        },
        error: function (data) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);
        }
    });

});