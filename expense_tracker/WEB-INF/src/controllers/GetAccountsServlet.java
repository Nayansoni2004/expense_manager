package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import models.Account;
import models.User;

@WebServlet("/getAccounts.do")
public class GetAccountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        String ans = "false";
        if(user != null){
            ArrayList<Account> accounts = user.getAllAccounts();
            Gson gson = new Gson();
            ans = gson.toJson(accounts);
        }

        resp.getWriter().write(ans);
    }
}
