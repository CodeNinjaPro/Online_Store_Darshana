function login() {
    var username = $('#username').val();
    var password = $('#password').val();

    $.ajax({
        url: 'LoginServlet',
        method: 'POST',
        data: {username: username, password: password},
        success: function (resultText) {
            if (resultText == 1) {
                location.replace("attendance.jsp");
            } else {
                alert("Username or Password Incorrect");
            }

        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax");
        }
    });
}

