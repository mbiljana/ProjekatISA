$(document).ready(function(){

    const kord = new Array();
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
                kord.push(data[i]['latitude'],data[i]['longitude']);

                $('#regReq').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
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
        selektovanRed = this.dataset.id;                    // cuvamo id selektovanog termina
        staraBoja = $(this).css('background-color');        // cuvamo staru boju da bi vratili kad se odselektuje

        $(this).css('background-color', '#a6c9e2');         // postavljamo novu boju
        console.log("Selektovan red ", selektovanRed);      // ispis u konzolu radi provere
    });

    ymaps.ready(init);
    function init(){
        if(selektovanRed == 8){
            var myMap = new ymaps.Map("mapa", {
                center: [kord[0],kord[1]],
                zoom: 12
            });
        }else{
            var myMap = new ymaps.Map("mapa", {
                center: [4.15,4.15],
                zoom: 12
            });
        }
    }


    $("#img").click(function() {
        if(selektovanRed == 8){
            document.getElementById("image1").src = "images/boat1.jpg";
            document.getElementById("image2").src = "images/bi1.jpg";
            document.getElementById("image3").src = "images/s1.jpg";
        }else {
            document.getElementById("image1").src = "images/boat2.jpg";
            document.getElementById("image2").src = "images/bi3.jpg";
            document.getElementById("image3").src = "images/s11.jpg";
        }

    });


});