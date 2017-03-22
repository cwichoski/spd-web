<%-- 
    Document   : NewFuncionario
    Created on : Mar 21, 2017, 6:39:29 PM
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>::: NOVO FUNCIONARIO :::</title>
    </head>
    <body>
        <form action="Funcionario" method="post">

            <label for="txtNome">NOME:</label>
            <input type="text" id="txtNome" name="txtNome"/><br>
            
            <label for="txtNome">Data de Nascimento:</label>
            <input type="text" id="txtDtNasc" name="txtDtNasc"/><br>
            
            <label for="txtCpf">CPF:</label>
            <input type="text" id="txtCpf" name="txtCpf"/><br>

            <label for="txtRua">RUA:</label>
            <input type="text" id="txtRua" name="txtRua"/><br>

            <label for="txtCep">CEP:</label>
            <input type="text" id="txtCep" name="txtCep"/><br>

            <label for="txtCidade">CIDADE:</label>
            <input type="text" id="txtCidade" name="txtCidade"/><br>

            <input type="submit" id="OPERACAO" name="OPERACAO" value="SALVAR">
            


        </form>
        <form action="http://localhost:8080/CRUD-web">
            <input type="submit" value="VOLTAR" />
        </form>
        <% String msg = (String)request.getAttribute("NewFuncionario");%>
    </body>
</html>
<script type="text/javascript">
    var msg = "<%=msg%>";
    if (msg !== "null"){
        alert(msg);
    }
    
</script>