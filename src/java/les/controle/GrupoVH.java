/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.controle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import les.aplicacao.Resultado;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Grupo;

/**
 *
 * @author gustavo
 */
class GrupoVH extends AbstractVH {

    public GrupoVH(){
		super("Grupo");
	}
	
	
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		operacao = request.getParameter("OPERACAO");		
		int id=0;
		String descricao =null;	

		
                
		if(operacao.equals("SALVAR")){
			
                    descricao = request.getParameter("txtDescricao");
                   
                    
                
		}else if(operacao.equals("EXCLUIR")){		
                    id  = Integer.parseInt(request.getParameter("txtID"));
                }else if(operacao.equals("CONSULTAR") ){		
                    if (request.getParameter("txtID") != null){
                        id  = Integer.parseInt(request.getParameter("txtID"));
                    }
                    
		}else if(operacao.equals("EDITAR")){
                    if (request.getParameter("txtID") != null){
                        id  = Integer.parseInt(request.getParameter("txtID"));
                    }
 
                    descricao = request.getParameter("txtDescricao");
                   

                    
                }else if(operacao.equals("NOVO")){
                    
                }	
		
		Grupo grupo = new Grupo();
		grupo.setId(id);
		grupo.setDescricao(descricao);
                
		return grupo;
	}
        
     public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operacao = request.getParameter("OPERACAO");		
        Servlet servlet = new Servlet();
        
        if(operacao.equals("SALVAR")){
 
            request.setAttribute("ConsultaGrupo", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("IndexGrupo.jsp");	
            
            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("EXCLUIR")){
            
            request.setAttribute("ConsultaGrupo", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("IndexGrupo.jsp");		

            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("EDITAR")){
            request.setAttribute("ConsultaGrupo", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("/Grupo?OPERACAO=CONSULTAR&txtID=0");		
        
            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("NOVO")){
            request.setAttribute("ConsultaGrupo", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("NewGrupo.jsp");		

            rd.forward(request, response);
        }else {
            
            String uri = request.getRequestURI();
            request.setAttribute("SelectGrupo", resultado);
            RequestDispatcher rd;
            Resultado result = (Resultado)resultado;
            List<EntidadeDominio> ls = result.getEntidades();
            
            
            if (uri.equals("/CRUD-web/SelectGrupo")){//se trazer apenas um objeto, manda para tela de editar
                request.setAttribute("ConsultaGrupo", resultado);
                rd = request.getRequestDispatcher("EditGrupo.jsp");		
            } else {
                rd = request.getRequestDispatcher("IndexGrupo.jsp");		
            }
            
            rd.forward(request, response);
        }
    }
}
