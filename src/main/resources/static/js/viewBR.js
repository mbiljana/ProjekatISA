$(document).ready(function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/boats/allReservations",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere
            for (i = 0; i < data.length; i++) {
                var row = "<tr data-id=" + data[i]['id'] + ">";                                  // kreiramo red za tabelu
                row += "<td>" + data[i]['resName'] + "</td>";
                row += "<td>" + data[i]['startDate'] + "</td>";
                row += "<td>" + data[i]['capacity'] + "</td>";
                row += "<td>" + data[i]['duration'] + "</td>";
                row += "<td>" + data[i]['price'] + "</td>";
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
        selektovanRed = this.dataset.id;

        localStorage.setItem('rezkor',this.dataset.id);
        window.location.href = "viewOneUser.html";
        console.log("Selektovan red ", this.dataset.id);      // ispis u konzolu radi provere
    });


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
                row += "<td>" + data[i]['endDate'] + "</td>";
                row += "<td>" + data[i]['duration'] + "</td>";
                row += "<td>" + data[i]['income'] + "</td>";
                row += "</tr>";
                $('#fastReq').append(row);
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });



    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/boats/income",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);
                var income =  data['income'] ;
                $('#income').append(income);
            },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });

});
