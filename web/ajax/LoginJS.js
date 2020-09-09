function login() {
    var username = $('#username').val();
    var password = $('#password').val();

    $.ajax({
        url: 'LoginServlet',
        method: 'POST',
        data: {username: username, password: password},
        success: function (resultText) {
            var rs = parseInt(resultText);
            if (rs === 1) {
                location.replace("customer.jsp");
            } else {
                alert("Username or Password Incorrect");
                document.getElementById(password).focus();
                alert("d");
            }

        },
        error: function (jqXHR, exception) {
            alert("Fail Ajax");
        }
    });
}

