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
    var newFitnesCentarJSON=formToJSON(cottageName, cottageAddress, cottageDescription,numRooms,numBeds,cottageAdditionalServices,cottageRules,conditions);

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
function formToJSON(cottageName, cottageAddress, cottageDescription,numRooms,numBeds,cottageAdditionalServices,cottageRules,conditions){
    return JSON.stringify({
        "cottageName" : cottageName,
        "cottageAddress" : cottageAddress,
        "cottageDescription" : cottageDescription,
        "numRooms" : numRooms,
        "numBeds" : numBeds,
        "cottageAdditionalServices" : cottageAdditionalServices,
        "cottageRules" : cottageRules,
        "conditions" :conditions
    });

}