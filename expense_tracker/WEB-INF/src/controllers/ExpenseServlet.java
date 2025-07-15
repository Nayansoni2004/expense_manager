package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Transaction;

@WebServlet("/expense.do")
public class ExpenseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String remark = req.getParameter("remark");

        String rsp = "false";

        int current = Account.fetchBalance(id);
        if(current>=amount){
            Account.update(id, current-amount);
            Transaction trs = new Transaction(id, remark, "debit", amount);
            if(trs.completeTransaction())rsp = "true";
        }


        resp.getWriter().write(rsp);
    }
}
