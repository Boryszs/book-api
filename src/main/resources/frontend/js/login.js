
function validate(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    $.ajax({
        type: "POST",
        url: "http://127.0.0.1:8080/user/authenticate",
        data: JSON.stringify({username:username,password:password}),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data) {
            console.log(data.jwt_token);
        },
        error:function (xhr) {
            console.log("error");
        }
    });
}