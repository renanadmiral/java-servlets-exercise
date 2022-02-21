package com.example.santander;

import com.example.santander.model.AccountModel;
import com.example.santander.model.AccountsList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "accountList", value = "/contas")
public class AccountServlet extends HttpServlet {

    AccountsList accountList = new AccountsList();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountModel conta = new AccountModel(
                request.getParameter("accountNumber"),
                request.getParameter("agencyNumber"),
                request.getParameter("clientId"),
                request.getParameter("bankName")
        );


        accountList.adiciona(conta);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("registeredAccount.jsp");
        request.setAttribute("accountNumber", conta.getAccountNumber());
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<AccountModel> accounts = accountList.findAccount();

        request.setAttribute("accounts", accounts);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("accountList.jsp");
        requestDispatcher.forward(request, response);

    }



}
