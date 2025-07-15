<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Expense Tracker APP</title>
    <link rel="stylesheet" href="static/css/main.css">
    <link rel="stylesheet" href="static/css/home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="static/css/trans.css">

    <style></style>

</head>

<body>
    <!-- navbar -->
     <%@ include file="header.jsp" %>
    <!-- Home Page -->

    <div id="blur-box" >
        <form id="create-acc-form" >
            <i class="fa-solid fa-x" id="cancel-create-acc"></i>
            <h1>Add Account</h1>
            <div>
                <label for="acc-name">Account Name : </label>
                <input type="text" id="acc-name" name="name" placeholder="Enter Account Name...">
            </div>

            <div>
                <label for="acc-balance">Initial Balance :</label>
                <input type="number" name="balance" id="acc-balance" placeholder="Enter Initial Balance ...">
            </div>

            <input type="submit" value="Create" id="create-acc-btn">
        </form>

        <form id="add-amount-box">
            <i class="fa-solid fa-x" id="add-amount-cancel"></i>
            <h1>Add Amount</h1>

            <div>
                <label for="add-amt">Amount : </label>
                <input type="number" id="add-amt" name="amount" placeholder="Enter Amount ...">
            </div>

            <div>
                <label for="add-remark">Remark :</label>
                <input type="text" name="remark" id="add-remark" placeholder="Enter Remark ...">
            </div>

            <input type="submit" value="Add" id="add-amt-btn">
        </form>

        <!-- Expense Amount  -->
        <form id="exp-amount-box">
            <i class="fa-solid fa-x" class="canc-btn" id="exp-amount-cancel"></i>
            <h1>Expense Amount</h1>

            <div>
                <label for="exp-amt">Amount : </label>
                <input type="number" id="exp-amt" name="amount" placeholder="Enter Amount ...">
            </div>

            <div>
                <label for="exp-remark">Remark :</label>
                <input type="text" name="remark" id="exp-remark" placeholder="Enter Remark ...">
            </div>

            <input type="submit" value="Add" class="cust-btn" id="exp-amt-btn">
        </form>
         <!-- --- -->


         <!-- Transfer Amount  -->
        <form id="trp-amount-box">
            <i class="fa-solid fa-x" class="canc-btn" id="trp-amount-cancel"></i>
            <h1>Transfer Amount</h1>

            <div>
                <label for="trp-to">Transfer To: </label>
                <select name="tranfer" id="trp-to">
                </select>
            </div>

            <div>
                <label for="trp-amt">Amount : </label>
                <input type="number" id="trp-amt" name="amount" placeholder="Enter Amount ...">
            </div>

            <div>
                <label for="trp-remark">Remark :</label>
                <input type="text" name="remark" id="trp-remark" placeholder="Enter Remark ...">
            </div>

            <input type="submit" value="Transfer" class="cust-btn" id="trp-amt-btn">
        </form>
         <!-- --- -->

           

         <!-- Transections -->
         <form id="transactions-box">
            <i class="fa-solid fa-x"  id="trans-cancel"></i>
            <h1>Trasactions</h1>
            
            <span id="all-transactions">
                <div class="transaction">
                    <div>
                        <span>Transaction Id - 2234</span>
                        <span>Trasaction Type - debit</span>
                    </div>
                    <div>
                        <span>Amount - 4000</span>
                        <span>Time - 12/11/2003 12:33:00</span>
                    </div>
                    <div>
                        Remark - Sold Item
                    </div>
                </div>
                
                
            </span>
            

            
        </form>
         <!-- --- -->

        
    </div>

    <div id="container">
        <button id="create-account">Create Account</button>
        <h1>All Accounts</h1>
        <!-- <div id="main-box">
            <div id="left">Expense
                <span>4000</span>
            </div>
            <div id="right">Income
                <span>2000</span>
            </div>
            <div id="total">Total
                <span>8000</span>
            </div>
        </div> -->

        <div id="accounts">
   
        </div>
    </div>
    

    <script src="static/js/home.js"></script>
    <script src="static/js/home1.js"></script>
</body>

</html>