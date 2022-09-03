const request = new XMLHttpRequest();
request.open('POST', "http://localhost:8181/auth/login", false, "admin","123")
request.onreadystatechange = function() {
    // D some business logics here if you receive return
    if(request.readyState === 4 && request.status === 200) {
        console.log(request.responseText);
    }
}
request.send()