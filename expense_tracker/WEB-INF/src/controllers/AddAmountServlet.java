package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import models.Transaction;

@WebServlet("/add_amount.do")
public class AddAmountServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        String remark = req.getParameter("remark");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String rsp = "false";

        Transaction trs = new Transaction(id, remark, amount);
        if(trs.addAmount()){
            int bal = Account.fetchBalance(id);
            if(Account.update(id,bal+amount))rsp = "true";
        }

        resp.getWriter().write(rsp);
  
    }
}
