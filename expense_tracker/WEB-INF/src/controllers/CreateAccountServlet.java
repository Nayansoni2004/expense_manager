package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Account;
import models.User;

@WebServlet("/create_account.do")
public class CreateAccountServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/createacc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName = req.getParameter("name");
        Integer amount = Integer.parseInt(req.getParameter("balance"));
        HttpSession session = req.getSession();

        User user = (User)session.getAttribute("user"); 
        String rsp = "false";

        Account account = new Account(accountName, user, amount, 1);
        if(account.createAccount()){
            rsp = "true";
        }

        resp.getWriter().write(rsp);
    }
    
}
