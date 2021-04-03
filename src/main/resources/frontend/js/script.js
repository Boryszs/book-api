
logIn = () =>{
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    $.ajax({
        type: "POST",
        url: "http://127.0.0.1:8080/user/authenticate",
        async:true,
        data: JSON.stringify({username: username, password: password}),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (response) {
            Cookies.set("token", JSON.stringify(response), {sameSite: 'strict'}, {secure: true});
            // Cookies.set("token", data.jwt_token, {sameSite: 'strict'}, {secure: true});
            // Cookies.set("id", data.id, {sameSite: 'strict'}, {secure: true});
            window.location.href = 'books.html';
        },
        error: function (xhr) {
            console.log("error");
        }
    });
}

logOut = () => {
    Cookies.remove('token');
    window.location.href = 'login.html';
}
