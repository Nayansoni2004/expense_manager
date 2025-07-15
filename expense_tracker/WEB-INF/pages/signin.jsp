<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp Page</title>
    <link rel="stylesheet" href="static/css/main.css">

    <style>
        #signupform {
            width: 50%;
            /* height: 50%; */
            height: max-content;
            background-color: #fff;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px #123232;
        }

        #signupform>h1 {
            margin: 10px;
            margin-top: 20px;
        }

        #signupform>div {
            width: 100%;
            margin-bottom: 10px;
        }

        label {
            display: block;
            font-size: 20px;
        }

        input {
            width: 90%;
            height: 30px;
            padding-left: 5px;
        }

        #sub-div {
            text-align: center;
        }

        #btn {
            width: max-content;
            padding: 5px 10px;
            background-color: blue;
            color: #fff;
            border: none;
            border-radius: 6px;
            margin-top: 10px;
        }
    </style>
</head>

<body>
    <%@ include file="header.jsp" %>

    <div id="main-container">
        <form action="sign_in.do" id="signupform" method="post">
            <h1>SignIn</h1>
            <div>
                <label for="email">Email : </label>
                <input type="text" name="email" id="email">
                <small id="email-error" style="display: block; color: red; visibility: hidden;">Invalid email address.</small>
            </div>
            <div>
                <label for="name">Password : </label>
                <input type="password" name="password" id="password">
            </div>
            <div id="sub-div">
                <input type="submit" id="btn">
            </div>
        </form>
        <script>
            document.getElementById("signupform").addEventListener("submit", function (event) {
                let isValid = true;
    
                // Get email input and error element
                const email = document.getElementById("email");
                const emailError = document.getElementById("email-error");
    
                // Regular expression for email validation
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
                // Validate email
                if (!emailPattern.test(email.value.trim())) {
                    isValid = false;
                    emailError.style.visibility = "visible";
                } else {
                    emailError.style.visibility = "hidden";
                }
    
                // Prevent form submission if validation fails
                if (!isValid) {
                    event.preventDefault();
                }
            });
        </script>
    </div>
    
</body>

</html>