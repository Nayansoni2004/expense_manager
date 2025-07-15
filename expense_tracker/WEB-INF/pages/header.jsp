<%@ page import="models.User" %>

    <link rel="stylesheet" href="static/css/header.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <div id="navbar">
        <div id="logo">
            <h1>Expense Buddy</h1>
        </div>

        <% User user = (User)session.getAttribute("user"); 
        %>

            <div id="nav-options">
                <% if(user == null){ %>
                    <a href="sign_in.do" class="nav-btns">SignIn</a>
                    <a href="sign_up.do" class="nav-btns">Registor</a>
                <% }else{ %>
                    <i class="fa-solid fa-user" style="font-size: 26px; margin-right: 20px;" id="user-option"></i>
                    <div id="user-op-box">
                        <i class="fa-solid fa-xmark" id="nav-cancel"></i>
                        <a href="">Reports/Insights</a>
                        <a href="logout.do">Log Out</a>
                    </div>

                    <script src="static/js/header.js"></script>
                <% } %>
            </div>
    </div>