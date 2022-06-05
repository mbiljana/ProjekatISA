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
        var newFitnesCentarJSON=formToJSON(boatName, boatType, engineNumber,enginePower,maxSpeed,boatAddress,boatCapacity,boatRules,boatDescription,additionalEquipment,navigationEguipment,conditions);

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
    function formToJSON(boatName, boatType, engineNumber,enginePower,maxSpeed,boatAddress,boatCapacity,boatRules,boatDescription,additionalEquipment,navigationEguipment,conditions){
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
        "conditions" : conditions
    });

    }