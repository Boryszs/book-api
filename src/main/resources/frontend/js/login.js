function validate() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    $.ajax({
        type: "POST",
        url: "http://192.168.1.109:8080/user/authenticate",
        data: JSON.stringify({username: username, password: password}),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {

            Cookies.set("token",data.jwt_token, {sameSite: 'strict' },{ expires: 7, path: '' },{secure:true});
            console.log(Cookies.get("token"));
            window.location.href = 'books.html';
        },
        error: function (xhr) {
            console.log("error");
        }
    });
}