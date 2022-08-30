$(document).ready(function(){

    let imageSrc = '';
    let longitude = 0;
    let latitude = 0;
    let boatName='';
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/boats/all",
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (i = 0; i < data.length; i++) {
                console.log(localStorage.getItem('boat'));
                var row = "<tr data-id=" + data[i]['id'] + ">";
                console.log(data[i]['id']);
                row += "<td>" + data[i]['boatName'] + "</td>";
                row += "<td>" + data[i]['boatType'] + "</td>";
                row += "<td>" + data[i]['boatDescription'] + "</td>";
                row += "<td>" + data[i]['srednjaOcena'] + "</td>";
                imageSrc = data[i]['image'];
                longitude = data[i]['longitude'];
                latitude = data[i]['latitude'];
                localStorage.setItem('imageSource', imageSrc);

                row += "</tr>";                                     // završavamo kreiranje reda
                if(localStorage.getItem('boat') == data[i]['id']){

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
