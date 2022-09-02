$(document).on("submit","form",function(event){
    event.preventDefault();

        var boatName = $("#boatName").val();
        var boatType = $("#boatType").val();
        var engineNumber = $("#engineNumber").val();
        var enginePower = $("#enginePower").val();
        var maxSpeed = $("#maxSpeed").val();
        var boatAddress = $("#boatAddress").val();
        var boatCapacity = $("#boatCapacity").val();
        var boatRules = $("#boatRules").val();
        var boatDescription = $("#boatDescription").val();
        var additionalEquipment = $("#additionalEquipment").val();
        var navigationEguipment = $("#navigationEguipment").val();
        var conditions= $("#conditions").val();
        var latitude= $("#latitude").val();
        var longitude= $("#longitude").val();
        var imageEnt1 = $("#imageEnt1").val();
        //imageEnt1.slice(12);
        console.log(imageEnt1);
        var imageEnt2 = $("#imageEnt2").val();
        //imageEnt2.substring(12);
        var imageExt1 = $("#imageExt1").val();
        //imageExt1.substring(12);
        var imageExt2 = $("#imageExt2").val();
        //imageExt2.substring(12);
        var newFitnesCentarJSON=formToJSON(boatName, boatType, engineNumber,enginePower,maxSpeed,boatAddress,boatCapacity,boatRules,boatDescription,additionalEquipment,navigationEguipment,conditions,imageEnt1,imageEnt2,imageExt1,imageExt2,latitude,longitude);

        $.ajax({
            type: "POST",
            url: "http://localhost:8181/api/boats/createBoat",
            dataType: "json",
            contentType: "application/json",
            data: newFitnesCentarJSON,
            success: function () {
                alert("Uspesno dodat brod");
                window.location.href = "boatPage.html";
            }
        });

    });
    function formToJSON(boatName, boatType, engineNumber,enginePower,maxSpeed,boatAddress,boatCapacity,boatRules,boatDescription,additionalEquipment,navigationEguipment,conditions,imageEnt1,imageEnt2,imageExt1,imageExt2,latitude,longitude){
    return JSON.stringify({
        "boatName" : boatName,
        "boatType" : boatType,
        "engineNumber" : engineNumber,
        "enginePower" : enginePower,
        "maxSpeed" : maxSpeed,
        "boatAddress" : boatAddress,
        "boatCapacity" : boatCapacity,
        "boatRules" : boatRules,
        "boatDescription" : boatDescription,
        "additionalEquipment" : additionalEquipment,
        "navigationEguipment" : navigationEguipment,
        "conditions" : conditions,
        "imageEnt1" : imageEnt1,
        "imageEnt2" : imageEnt2,
        "imageExt1": imageExt1,
        "imageExt2": imageExt2,
        "latitude" : latitude,
        "longitude" : longitude
    });

    }
