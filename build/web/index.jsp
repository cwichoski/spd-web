<%-- 
    Document   : index
    Created on : Mar 18, 2017, 12:55:15 PM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Funcionário</h1>
        <form action="http://localhost:8080/CRUD-web/NewFuncionario.jsp">
            <input type="submit" value="Novo" />
        </form>
        <form action="http://localhost:8080/CRUD-web/EditFuncionario.html">
            <input type="submit" value="Alterar" />
        </form>
        <form action="http://localhost:8080/CRUD-web/DeleteFuncionario.jsp">
            <input type="submit" value="Excluir" />
        </form>
        <form action="Funcionario">
             <input type="submit" id="OPERACAO" name="OPERACAO" value="Consultar">
        </form>
 
        
    </body>
</html>
