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
import les.dominio.Diario;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.dominio.Grupo;
import les.dominio.Propriedade;
import les.dominio.Doenca;
import les.dominio.PerguntasDoenca;

/**
 *
 * @author gustavo
 */
class DoencaVH extends AbstractVH {

    public DoencaVH(){
		super("Diario");
	}
	
	
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		operacao = request.getParameter("OPERACAO");		
		int id=0;
                Doenca dnca = new Doenca();
                
                String id_doenca = null;
		
                
		if(operacao.equals("SALVAR")){
                    id_doenca = request.getParameter("id");
                   
                
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
                    String[] perguntas = request.getParameterValues("txt_Pergunta");
                    String[] tipo = request.getParameterValues("txt_tipo");
                    List<PerguntasDoenca> pgts = new ArrayList<PerguntasDoenca>();
                    String caminho_arquivo;
                    caminho_arquivo = request.getParameter("fileToUpload");
                    String nome = request.getParameter("txtNome");
                    
                        for(int i = 0; i < perguntas.length; i++){
                        PerguntasDoenca pg = new PerguntasDoenca();
                        pg.setDescricao(perguntas[i]);
                        pg.setTipo(tipo[i]);
                        pg.setOrdem(i);
                        pgts.add(pg);
                                
                        

                        
                    }
                    dnca.setDescricao(nome);
                    dnca.setArquivo(caminho_arquivo);
                    dnca.setDoencas(pgts);
                   

                    
                }else if(operacao.equals("NOVO")){
                    
                }	
		
                
                dnca.setId(id);
                
              
                
            
		return dnca;
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
            request.setAttribute("ConsultaDoenca", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("IndexDoenca.jsp");		
        
            servlet.init(request);
            rd.forward(request, response);
        } else if(operacao.equals("NOVO")){
            request.setAttribute("ConsultaGrupo", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("NewGrupo.jsp");		

            rd.forward(request, response);
        }else {
            
            String uri = request.getRequestURI();
            request.setAttribute("ConsultaDoenca", resultado);
            RequestDispatcher rd;
            Resultado result = (Resultado)resultado;
            List<EntidadeDominio> ls = result.getEntidades();
            
            
            if (uri.equals("/CRUD-web/SelectDoenca")){//se trazer apenas um objeto, manda para tela de editar
                rd = request.getRequestDispatcher("EditDoenca.jsp");		
            } else {
                rd = request.getRequestDispatcher("IndexPropriedade.jsp");		
            }
            
            rd.forward(request, response);
        }
    }
}
