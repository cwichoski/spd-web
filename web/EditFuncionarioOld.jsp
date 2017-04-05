<%-- 
    Document   : EditFuncionario
    Created on : 22/03/2017, 12:41:04
    Author     : giter
--%>

<%@page import="java.util.List"%>
<%@page import="les.dominio.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Funcionario</h1>
        <form action="SelectFuncionario" method="post">

            <label for="txtID">Insira o Id para editar:</label>
            <input type="text" id="txtID" name="txtID"/>
            
            <input type="submit" id="OPERACAO" name="OPERACAO" value="CONSULTAR"><br>
            
        </form>

        <form action="http://localhost:8080/CRUD-web">
            <input type="submit" value="VOLTAR" />
        </form>
        <% String msg = (String)request.getAttribute("EditarFuncionario");%>
    </body>
</html>
<script type="text/javascript">
    var msg = "<%=msg%>";
    if (msg !== "null"){
        alert(msg);
    }
    
</script>
