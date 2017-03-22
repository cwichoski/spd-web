<%-- 
    Document   : DeleteFuncionario
    Created on : Mar 22, 2017, 12:59:14 AM
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
        <h1>Insira o Id do funcionario</h1>
        <form action="Funcionario" method="post">

            <label for="txtNome">Insira o Id para excluir:</label>
            <input type="text" id="txtID" name="txtID"/><br>
            
            <input type="submit" id="OPERACAO" name="OPERACAO" value="EXCLUIR">
            
        </form>
        <form action="http://localhost:8080/CRUD-web">
            <input type="submit" value="VOLTAR" />
        </form>
        <% String msg = (String)request.getAttribute("DeleteFuncionario");%>
    </body>
</html>
<script type="text/javascript">
    var msg = "<%=msg%>";
    if (msg !== "null"){
        alert(msg);
    }
    
</script>
