$(document).ready(function(){

    const kord = new Array();
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
                kord.push(data[i]['latitude'],data[i]['longitude']);
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


        ymaps.ready(init);
        function init(){
            if(selektovanRed == 6){
                var myMap = new ymaps.Map("map", {
                    center: [kord[0],kord[1]],
                    zoom: 12
                });
            }else{
                var myMap = new ymaps.Map("map", {
                    center: [4.15,4.15],
                    zoom: 12
                });
            }
        }

    $("#img").click(function() {
        if(selektovanRed == 5){
            document.getElementById("image1").src = "images/cott.jpg";
            document.getElementById("image2").src = "images/int1.jpg";
            document.getElementById("image3").src = "images/n1.jpg";
        }else if(selektovanRed == 6){
            document.getElementById("image1").src = "images/cott2.jpg";
            document.getElementById("image2").src = "images/int2.jpg";
            document.getElementById("image3").src = "images/n2.jpg";
        }else if(selektovanRed == 7){
            document.getElementById("image1").src = "images/cott3.jpg";
            document.getElementById("image2").src = "images/int3.jpg";
            document.getElementById("image3").src = "images/n3.jpg";
        }else{
            document.getElementById("image1").src = "images/cott4.jpg";
            document.getElementById("image2").src = "images/int4.jpg";
            document.getElementById("image3").src = "images/n4.jpg";
        }

        });








});