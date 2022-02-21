<%@ page import="java.util.List" %>
<%@ page import="com.example.santander.model.AccountModel" %><%--
  Created by IntelliJ IDEA.
  User: cinth
  Date: 16/02/2022
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Registro de contas</h1>
    <ul>
        <%
            List<AccountModel> accounts = (List)request.getAttribute("accounts");
            for(AccountModel account: accounts){
        %>
                <li>Número da Conta: <%= account.getAccountNumber()%></li>
                <li>Número da Agência: <%= account.getAgencyNumber()%></li>
                <li>Número do Cliente: <%= account.getClientId()%></li>
                <li>Nome do Banco: <%= account.getBankName()%></li>
        <br>
        <hr>
        <br>
      <%
          }
      %>
    </ul>
    <a href="/santander/cadastroConta">Cadastrar um novo cliente</a>
</body>
</html>
