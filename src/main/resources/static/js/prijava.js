$(document).ready(function(){

    $("#formaLogovanjeKorisnika").submit(function(event) {

        event.preventDefault();
        var username = $("#username").val().trim();
        var password= $("#password").val().trim();

        var obj = JSON.stringify({
            "username" : username,
            "password" : password
        });
        if(username != "" && password != "") {
            $.ajax({
                type: "POST",
                url: "http://localhost:8181/api/korisnik/login",
                dataType: "json",
                contentType: "application/json",
                data: obj,
                success: function (data) {

                    console.log("SUCCESS : ", data);

                    localStorage.setItem('id', data.id);
                    localStorage.setItem('name', data.name);
                    localStorage.setItem('surname', data.surname);
                    localStorage.setItem('emailAddress', data.emailAddress);
                    localStorage.setItem('phoneNumber', data.phoneNumber);
                    localStorage.setItem('city', data.city);
                    localStorage.setItem('state', data.state);
                    localStorage.setItem('homeAddress', data.homeAddress);
                    localStorage.setItem('username', data.username);
                    localStorage.setItem('password', data.password);
                    localStorage.setItem('role', data.role);

                    window.location.href = "index.html";
                },
                error: function (data) {
                    console.log("ERROR " + JSON.stringify(data));
                    alert("Nalog nije aktivan, proverite unos ili se obratite adminu");
                }
            });

        }


    });
});
