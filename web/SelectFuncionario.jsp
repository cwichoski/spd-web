<%-- 
    Document   : SelectFuncionario
    Created on : Mar 21, 2017, 7:16:53 PM
    Author     : gustavo
--%>

<%@page import="les.dominio.Endereco"%>
<%@page import="les.controle.ConsultarCommand"%>
<%@page import="les.dominio.ICommand"%>
<%@page import="les.dominio.EntidadeDominio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="les.dominio.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consulta de todos os funcionários</h1>

        <%Funcionario funcionario = new Funcionario();
            List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("SelectFuncionario");    
                        
            EntidadeDominio entidade = new Funcionario();
            ConsultarCommand cmd = new ConsultarCommand();
            cmd.executar2(entidade);
            
            for(Funcionario func : funcionarios) {
                out.println("ID: ");
                out.println(func.getId() + " ");
                out.println("Nome: ");
                out.println(func.getNome() + " ");
                out.println("CPF: ");
                out.println(func.getCpf());
                out.println("Data de Nascimento: ");
                out.println(func.getDt_nasc() + "<br>");

                
            }
            


        %>

         <form action="http://localhost:8080/CRUD-web">
            <input type="submit" value="Voltar" />
        </form>
  
    </body>
</html>
