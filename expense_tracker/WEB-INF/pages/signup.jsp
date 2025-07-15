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

        #error-box {
            color: red;
            padding-left: 4px;
            visibility: hidden;
        }
    </style>
</head>

<body>
    <%@ include file="header.jsp" %>

    <div id="main-container">
        <form action="sign_up.do" id="signupform" method="post">
            <h1>SignUp</h1>
            <div>
                <label for="name">Name : </label>
                <input type="text" name="name" id="name" required>
                <small id="name-err" style="visibility: hidden; color: red; display: block;"></small>
            </div>
            <div>
                <label for="email">Email : </label>
                <input type="text" name="email" id="email" required>
                <small id="email-err" style="visibility: hidden; color: red; display: block;"></small>
            </div>
            <div>
                <label for="name">Password : </label>
                <input type="password" name="password" id="password" required>
                <small id="password-err" style="visibility: hidden; color: red; display: block;"></small>
            </div>
            <div id="sub-div">
                <input type="submit" id="btn">
            </div>
        </form>
        <script>
            document.getElementById("signupform").addEventListener("submit", function (event) {
                let isValid = true;
    
                // Get input fields and error elements
                const name = document.getElementById("name");
                const email = document.getElementById("email");
                const password = document.getElementById("password");
    
                const nameErr = document.getElementById("name-err");
                const emailErr = document.getElementById("email-err");
                const passwordErr = document.getElementById("password-err");
    
                // Regular expressions
                const namePattern = /^[A-Za-z\s]+$/; // Name: only letters and spaces
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // Email: standard email format
                const passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/; // Password
    
                // Validate Name
                if (!namePattern.test(name.value.trim())) {
                    isValid = false;
                    nameErr.style.visibility = "visible";
                    nameErr.textContent = "Name must contain only letters and spaces.";
                } else {
                    nameErr.style.visibility = "hidden";
                }
    
                // Validate Email
                if (!emailPattern.test(email.value.trim())) {
                    isValid = false;
                    emailErr.style.visibility = "visible";
                    emailErr.textContent = "Enter a valid email address.";
                } else {
                    emailErr.style.visibility = "hidden";
                }
    
                // Validate Password
                if (!passwordPattern.test(password.value.trim())) {
                    isValid = false;
                    passwordErr.style.visibility = "visible";
                    passwordErr.textContent = "Password must be at least 8 characters, include uppercase, lowercase, number, and special character.";
                } else {
                    passwordErr.style.visibility = "hidden";
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