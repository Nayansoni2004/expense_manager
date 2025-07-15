<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account Page</title>
    <link rel="stylesheet" href="static/css/main.css">

    <style>
        #signupform{
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

        #signupform > h1{
            margin: 10px;
            margin-top: 20px;
        }

        #signupform > div{
            width: 100%;
            margin-bottom: 10px;
        }
        
        label{
            display: block;
            font-size: 20px;
        }

        input{
            width: 90%;
            height: 30px;
            padding-left: 5px;
        }

        #sub-div{
            text-align: center;
        }

        

        select {
            font-size: 20px;
            padding: 2px 3px;
            margin-top: 10px;

        }

        #btn{
            width: max-content;
            padding: 5px 10px;
            background-color: blue;
            color: #fff;
            border: none;
            border-radius: 6px;
            margin-top: 10px;
            font-weight: 500;
            font-size: 18px;
        }
        
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>

    <div id="main-container">
        <form action="create_account.do" id="signupform" method="post">
            <h1>SignUp</h1>
            <div>
                <label for="name">Account Name : </label>
                <input type="text" name="name" id="name">
            </div>
            <div>
                <label for="amount">Add Amount : </label>
                <input type="number" name="amount" id="amount">
            </div>
            <div>
                <label for="name">Account Type : </label>
                <select name="account_type">
                    <option value="1">Saving</option>
                    <option value="2">Card</option>
                    <option value="3">Cash</option>
                </select>
            </div>
            <div id="sub-div">
                <input type="submit" id="btn">
            </div>
        </form>
    </div>
    
</body>
</html>