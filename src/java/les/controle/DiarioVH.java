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
import les.dominio.Propriedade;
import les.dominio.Talhao;

/**
 *
 * @author gustavo
 */
class DiarioVH extends AbstractVH {

    public DiarioVH(){
		super("Diario");
	}
	
	
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		operacao = request.getParameter("OPERACAO");		
		int id=0;
                String doenca_s = null;
                String doenca_n = null;
		
                
		if(operacao.equals("SALVAR")){
                    String id_propriedades = request.getParameter("id");
                    doenca_s = request.getParameter("hide_chk_s");
                    doenca_n = request.getParameter("hide_chk_n");
                   
                    // on significa que o campo SIM não foi setado e está vazio
                    if(request.getParameter("hide_chk_s").equals("on") || request.getParameter("hide_chk_s").equals("false")){
                        // campo 'NÃO', foi setado
                        if (request.getParameter("hide_chk_n").equals("true") ){
                            doenca_n = "true";
                        }
                    } else{
                        // campo 'NÃO', foi setado
                        if (request.getParameter("hide_chk_n").equals("true") ){
                            doenca_n = "true";
                        }

                    }
                    
                
                
		}else if(operacao.equals("EXCLUIR")){		
                    id  = Integer.parseInt(request.getParameter("txtID"));
                }else if(operacao.equals("CONSULTAR") ){		
                    if (request.getParameter("txtPropriedade_ID") != null){
                        
                       
                        id  = Integer.parseInt(request.getParameter("txtPropriedade_ID"));
                    }
                    
		}else if(operacao.equals("EDITAR")){
                    if (request.getParameter("txtID") != null){
                        id  = Integer.parseInt(request.getParameter("txtID"));
                    }
 
                   
                   

                    
                }else if(operacao.equals("NOVO")){
                    
                }	
		
                Diario diario = new Diario();
		talhao.setId(id);
                Propriedade propriedade = new Propriedade();
            
		return talhao;
	}
        
     public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operacao = request.getParameter("OPERACAO");		
        Servlet servlet = new Servlet();
        
        if(operacao.equals("SALVAR")){
 
            request.setAttribute("ConsultaPropriedade", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("IndexPropriedade.jsp");	
            
            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("EXCLUIR")){
            
            request.setAttribute("ConsultaPropriedade", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("IndexPropriedade.jsp");		

            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("EDITAR")){
            request.setAttribute("ConsultaPropriedade", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("/Propriedade?OPERACAO=CONSULTAR&txtID=0");		
        
            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("NOVO")){
            request.setAttribute("ConsultaGrupo", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("NewGrupo.jsp");		

            rd.forward(request, response);
        }else {
            
            String uri = request.getRequestURI();
            request.setAttribute("SelectTalhao", resultado);
            RequestDispatcher rd;
            Resultado result = (Resultado)resultado;
            List<EntidadeDominio> ls = result.getEntidades();
            
            
            if (uri.equals("/CRUD-web/SelectTalhao")){//se trazer apenas um objeto, manda para tela de editar
                rd = request.getRequestDispatcher("IndexDiario2.jsp");		
            } else {
                rd = request.getRequestDispatcher("IndexPropriedade.jsp");		
            }
            
            rd.forward(request, response);
        }
    }
}
