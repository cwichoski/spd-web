<%-- 
    Document   : EditFuncionario2
    Created on : 22/03/2017, 15:40:40
    Author     : giter
--%>

<%@page import="les.dominio.Endereco"%>
<%@page import="les.dominio.Funcionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alteração</title>
    </head>
    <body>
        <h1>Alterar Funcionario</h1>
        <form action="Funcionario" method="post">
            <% List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("ConsultaFuncionario");    
                 for(Funcionario func : funcionarios) {               
            %>
                 
                 
            <label for="txtNome">NOME:</label>
            <input type="text" id="txtNome" name="txtNome" value="<%=func.getNome()%>"/><br>
            
            <label for="txtNome">Data de Nascimento:</label>
            <input type="text" id="txtDtNasc" name="txtDtNasc" value="<%=func.getDt_nasc()%>"/><br>
            
            <label for="txtCpf">CPF:</label>
            <input type="text" id="txtCpf" name="txtCpf" value="<%=func.getCpf()%>"/><br>
            <% Endereco end = func.getEnd(); %>
            <label for="txtRua">RUA:</label>
            <input type="text" id="txtRua" name="txtRua" value="<%=end.getRua()%>"/><br>

            <label for="txtCidade">CIDADE:</label>
            <input type="text" id="txtCidade" name="txtCidade" value="<%=end.getCidade()%>"/><br>            
            
            <label for="txtCep">CEP:</label>
            <input type="text" id="txtCep" name="txtCep" value="<%=end.getCep()%>"/><br>

            <input type="submit" id="OPERACAO" name="OPERACAO" value="EDITAR">
            <% }%>


        </form>
        <form action="http://localhost:8080/CRUD-web/EditFuncionario.jsp">
            <input type="submit" value="VOLTAR" />
        </form>

    </body>
</html>
