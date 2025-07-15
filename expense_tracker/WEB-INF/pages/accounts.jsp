<%@ page import="models.User,java.util.ArrayList,models.Account" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accounts Page</title>
    <link rel="stylesheet" href="static/css/main.css">
    <style>
        #main-container {
            display: block;
            background-color: rgb(246, 249, 248);
            text-align: center;
        }

        #main-container > h1{
            padding-top: 30px;
            padding-bottom: 20px;
        }

        #main-container>table{
            margin: 0 auto;
            font-size: 18px;
        }

        th,td{
            padding: 8px;
        }
        
        #create-acc{
            display: inline-block;
            margin-top: 60px;
            color: #fff;
            background-color: rgb(69, 131, 231);
            padding: 5px 10px;
            border-radius: 7px;
            text-decoration: none;
            margin-top: 60px;
            font-size: 20px;
        }
    </style>

</head>

<body>
    <%@ include file="header.jsp" %>
    <% ArrayList<Account> accounts = user.getAllAccounts(); 
        int count = 1;
        %>

        <div id="main-container">
            <h1>My Accounts</h1>
            <table border="1" align="center" width="60%">
                <tr>
                    <th>S. No.</th>
                    <th>Account Name</th>
                    <th>Account Type</th>
                    <th>Balance</th>
                    <th>Transfer</th>
                    <th>Transections</th>
                </tr>
                <% for(Account acc : accounts){ %>
                    <tr>
                        <td><%= count++ %></td>
                        <td><%= acc.getName() %></td>
                        <td><%= acc.getType() %></td>
                        <td><%= acc.getBalance() %></td>
                        <td> <a href="#">transfer_bal</a> </td>
                        <td><a href="#">view</a></td>
                    </tr>
                <% } %>
            </table>

            <a href="create_account.do" id="create-acc">Create New Account</a>
        </div>


</body>

</html>