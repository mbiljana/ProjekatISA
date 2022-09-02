$(document).on("submit","form",function(event){
    event.preventDefault();

    var cottageName = $("#cottageName").val();
    var cottageAddress = $("#cottageAddress").val();
    var cottageDescription = $("#cottageDescription").val();
    var numRooms = $("#numRooms").val();
    var numBeds = $("#numBeds").val();
    var cottageAdditionalServices = $("#cottageAdditionalServices").val();
    var cottageRules = $("#cottageRules").val();
    var conditions = $("#conditions").val();
    var latitude = $("#latitude").val();
    var longitude = $("#longitude").val();
    var imageEnt1 = $("#imageEnt1").val();
    //imageEnt1.slice(12);
    console.log(imageEnt1);
    var imageEnt2 = $("#imageEnt2").val();
    //imageEnt2.substring(12);
    var imageExt1 = $("#imageExt1").val();
    //imageExt1.substring(12);
    var imageExt2 = $("#imageExt2").val();
    var newFitnesCentarJSON=formToJSON(cottageName, cottageAddress, cottageDescription,numRooms,numBeds,cottageAdditionalServices,cottageRules,conditions,latitude, longitude,imageEnt1,imageEnt2,imageExt1,imageExt2);

    $.ajax({
        type: "POST",
        url: "http://localhost:8181/api/cottages/createCottage",
        dataType: "json",
        contentType: "application/json",
        data: newFitnesCentarJSON,
        success: function () {
            alert("Uspesno dodata vikendica");
            window.location.href = "cottagesPage.html";
        }
    });

});
function formToJSON(cottageName, cottageAddress, cottageDescription,numRooms,numBeds,cottageAdditionalServices,cottageRules,conditions,latitude, longitude, imageEnt1,imageEnt2,imageExt1,imageExt2){
    return JSON.stringify({
        "cottageName" : cottageName,
        "cottageAddress" : cottageAddress,
        "cottageDescription" : cottageDescription,
        "numRooms" : numRooms,
        "numBeds" : numBeds,
        "cottageAdditionalServices" : cottageAdditionalServices,
        "cottageRules" : cottageRules,
        "conditions" :conditions,
        "latitude" : latitude,
        "longitude" : longitude,
        "imageEnt1" : imageEnt1,
        "imageEnt2" : imageEnt2,
        "imageExt1": imageExt1,
        "imageExt2": imageExt2
    });

}
