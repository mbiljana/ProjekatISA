$(document).ready(function(){

    let imageCott1 = '';
    let imageCott2 = '';
    let imageCott3 = '';
    let imageCott4 = '';
    let longitude = 0;
    let latitude = 0;
    let boatName='';
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/cottages/all",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                console.log(localStorage.getItem('boat'));
                var row = "<tr data-id=" + data[i]['id'] + ">";
                // završavamo kreiranje reda
                if(localStorage.getItem('cottage') == data[i]['id']){
                    console.log(data[i]['id']);
                    row += "<td>" + data[i]['cottageName'] + "</td>";
                    row += "<td>" + data[i]['cottageAddress'] + "</td>";
                    row += "<td>" + data[i]['cottageDescription'] + "</td>";
                    row += "<td>" + data[i]['srednjaOcena'] + "</td>";
                    imageCott1 = data[i]['imageEnt1'];
                    imageCott2 = data[i]['imageEnt2'];
                    imageCott3 = data[i]['imageExt1'];
                    imageCott4 = data[i]['imageExt2'];
                    longitude = data[i]['longitude'];
                    latitude = data[i]['latitude'];
                    localStorage.setItem('imageCott1', imageCott1);
                    localStorage.setItem('imageCott2', imageCott2);
                    localStorage.setItem('imageCott3', imageCott3);
                    localStorage.setItem('imageCott4', imageCott4);
                    row += "</tr>";
                    $('#regReq').append(row);

                    break;
                }

                // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });

    ymaps.ready(init);
    function init(){
        var myMap = new ymaps.Map("map", {
            center: [latitude, longitude],
            zoom: 12
        });
    }


});
