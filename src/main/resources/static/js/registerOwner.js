$(document).on("submit","form",function(event){
    event.preventDefault();
    var username = $("#username").val();
    var password = $("#password").val();
    var password2 = $("#password2").val();
    var name = $("#name").val();
    var surname = $("#surname").val();
    var phoneNumber = $("#phoneNumber").val();
    var emailAddress = $("#emailAddress").val();
    var birthDate = $("#birthDate").val();
    var city = $("#city").val();
    var state = $("#state").val();
    var homeAddress = $("#homeAddress").val();
    var regType = $("#regType").val();
    var razlog = $("#razlog").val();

    //new way
    var newFitnesCentarJSON=formToJSON(username,password,password2,name,surname,phoneNumber,emailAddress,birthDate,city,state,homeAddress,regType,razlog);
    $.ajax({
        type: "POST",
        url: "http://localhost:8181/api/korisnik/registerOwner",
        dataType: "json",
        contentType: "application/json",
        data: newFitnesCentarJSON,
        success: function () {
            alert("Usesno poslat zahtev za registraciju");
            window.location.href = "index.html";
        },
        error: function (data) {
            alert("Da li se poruka prenela?");
            alert(data);
            alert("Izgleda da jeste");
        }
    });

    function formToJSON(username,password,password2,name,surname,phoneNumber,emailAddress,birthDate,city,state,homeAddress,regType,razlog){
        return  JSON.stringify({
            "username" : username,
            "password" : password,
            "password2" : password2,
            "name" : name,
            "surname" : surname,
            "phoneNumber" : phoneNumber,
            "emailAddress" : emailAddress,
            "birthDate" : birthDate,
            "city" : city,
            "state" : state,
            "homeAddress" : homeAddress ,
            "regType" : regType,
            "role" : 1,
            "razlog" : razlog
        });
    }
});
