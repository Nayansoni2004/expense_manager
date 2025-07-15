package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Account;
import models.Transaction;

@WebServlet("/get_trasactions.do")
public class GetTransections extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        ArrayList<Transaction> trasactions = Account.getTrasactions(id);

        Gson gson = new Gson();
        String rsp = gson.toJson(trasactions);

        resp.getWriter().print(rsp);
    }
}
