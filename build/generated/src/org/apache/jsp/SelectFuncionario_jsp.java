package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import les.dominio.Endereco;
import les.controle.ConsultarCommand;
import les.dominio.ICommand;
import les.dominio.EntidadeDominio;
import java.util.List;
import java.util.ArrayList;
import les.dominio.Funcionario;

public final class SelectFuncionario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Consulta de todos os funcionários</h1>\n");
      out.write("\n");
      out.write("        ");
Funcionario funcionario = new Funcionario();
            List<Funcionario> funcionarios = (List<Funcionario>) request.getAttribute("SelectFuncionario");    
            List<Endereco> enderecos = (List<Endereco>) request.getAttribute("SelectFuncionario");
            
            EntidadeDominio entidade = new Funcionario();
            ConsultarCommand cmd = new ConsultarCommand();
            cmd.executar2(entidade);
            int i = 0;
            for(Funcionario func : funcionarios) {
                out.println("ID: ");
                out.println(func.getId() + " ");
                out.println("Nome: ");
                out.println(func.getNome() + " ");
                out.println("CPF: ");
                out.println(func.getCpf());
                out.println("Data de Nascimento: ");
                out.println(func.getDt_nasc());
                out.println("Rua: ");
                out.println(enderecos.get(i).getRua()+" ");
                out.println("Cidade: ");
                out.println(enderecos.get(i).getCidade()+" ");
                out.println("CEP: ");
                out.println(enderecos.get(i).getCep()+"<br>");
                i++;
            }
            


        
      out.write("\n");
      out.write("\n");
      out.write("         <form action=\"http://localhost:8080/CRUD-web\">\n");
      out.write("            <input type=\"submit\" value=\"Voltar\" />\n");
      out.write("        </form>\n");
      out.write("  \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
