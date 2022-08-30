$(document).ready(function(){

    let imageSrc1 = '';
    let imageSrc2 = '';
    let imageSrc3 = '';
    let imageSrc4 = '';
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
                                                 // završavamo kreiranje reda
                if(localStorage.getItem('boat') == data[i]['id']){
                    console.log(data[i]['id']);
                    row += "<td>" + data[i]['boatName'] + "</td>";
                    row += "<td>" + data[i]['boatType'] + "</td>";
                    row += "<td>" + data[i]['boatDescription'] + "</td>";
                    row += "<td>" + data[i]['srednjaOcena'] + "</td>";
                    imageSrc1 = data[i]['imageEnt1'];
                    imageSrc2 = data[i]['imageEnt2'];
                    imageSrc3 = data[i]['imageExt1'];
                    imageSrc4 = data[i]['imageExt2'];
                    longitude = data[i]['longitude'];
                    latitude = data[i]['latitude'];
                    localStorage.setItem('imageSource1', imageSrc1);
                    localStorage.setItem('imageSource2', imageSrc2);
                    localStorage.setItem('imageSource3', imageSrc3);
                    localStorage.setItem('imageSource4', imageSrc4);
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
