package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Transaction;

@WebServlet("/tranfer.do")
public class TransferServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int from = Integer.parseInt(req.getParameter("from"));
        int to = Integer.parseInt(req.getParameter("to"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String remark = req.getParameter("remark");

        String rsp = "false";
        int current = Account.getAmount(from);
        int update = current - amount;
        if(update >= 0){
            if(Account.update(from, update)){
                int toAmount = Account.getAmount(to);
                Account.update(to, toAmount+amount);
                Transaction trs = new Transaction(from, remark, "debit-(to-"+to+")", amount);
                Transaction trs2 = new Transaction(to, remark, "credit-(from-"+from+")", amount);
                if(trs.completeTransaction() && trs2.completeTransaction())rsp = "true";
            }
        }

        resp.getWriter().write(rsp);
    }
}
