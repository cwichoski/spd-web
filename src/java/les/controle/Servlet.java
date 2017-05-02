/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import les.aplicacao.Resultado;
import les.dominio.ICommand;
import les.controle.Fachada;
import les.controle.IFachada;
import les.dominio.Cargo;
import les.dominio.EntidadeDominio;
import les.dominio.Grupo;


/**
 *
 * @author gustavo
 */
//@WebServlet("/servlet")

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Map<String, ICommand> commands;
    private Map<String, IViewHelper> vhs;

    
    public Servlet(){
        commands = new HashMap<String, ICommand>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("NOVO", new ConsultarCommand());
        commands.put("EDITAR", new AlterarCommand());
        
        vhs = new HashMap<String, IViewHelper>();
        
        vhs.put("/CRUD-web/Funcionario", new FuncionarioVH());
        vhs.put("/CRUD-web/SelectFuncionario", new FuncionarioVH());
        vhs.put("/CRUD-web/SelectGrupo", new GrupoVH());
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); 
        
        ICommand command = new ConsultarCommand();
        
        
        ServletContext application = getServletContext();
        
        // Inicializando a lista de Cargos 
        EntidadeDominio cargo = new Cargo();
        Resultado resultCargo = command.executar(cargo);
        List<EntidadeDominio> cargos = resultCargo.getEntidades();
                
        
        application.setAttribute("Cargo", cargos);
        
        // Inicializando a lista de Grupos 
        EntidadeDominio grupo = new Grupo();
        Resultado resultGrupo = command.executar(grupo);  
        List<EntidadeDominio> grupos = resultGrupo.getEntidades();
        
        application.setAttribute("Grupo", grupos);
      
      
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       		// Obt�m a uri que invocou esta servlet (O que foi definido no methdo do form html)
		String uri = request.getRequestURI();
				
		
		// Obt�m um viewhelper indexado pela uri que invocou esta servlet
    		IViewHelper vh = vhs.get(uri);
		
		// O viewhelper retorna a entidade especifica para a tela que chamou
				// esta servlet
		EntidadeDominio entidade = vh.getEntidade(request);

		
 		String operacao = request.getParameter("OPERACAO");
		
		ICommand cmd = commands.get(operacao);
                
                Resultado selectList = cmd.executar(entidade);
		
                vh.setView(selectList, request, response);
		
		
		
		
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
