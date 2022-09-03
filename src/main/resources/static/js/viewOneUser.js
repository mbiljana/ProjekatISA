$(document).ready(function(){
    var regkor = localStorage.getItem('rezkor');
    $.ajax({
        type: "GET",
        url: "http://localhost:8181/api/korisnik/one/" +regkor,
        dataType: "json",
        success: function (data) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", data);
            var name =  data['name'] ;
            $('#name').append(name);
            var surname =  data['surname'] ;
            $('#surname').append(surname);
            var emailAddress =  data['emailAddress'] ;
            $('#emailAddress').append(emailAddress);
            var phoneNumber =  data['phoneNumber'] ;
            $('#phoneNumber').append(phoneNumber);
            var city =  data['city'] ;
            $('#city').append(city);
            var homeAddress =  data['homeAddress'] ;
            $('#homeAddress').append(homeAddress);
            var username =  data['username'] ;
            $('#username').append(username);
        },
        error: function (response) {
            alert("Dogodila se greska, pogledaj konzolu");
            console.log("ERROR : ", data);

        }

    });

});
