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
import les.dominio.Cultura;
import les.dominio.Diario;
import les.dominio.Doenca;
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
                // quantidade de perguntas por doenca
                int qt_perguntas;
                String nm_doenca = null;
                int id_talhao = 0;
		
                Diario diario = new Diario();
                Cultura cultura = new Cultura();
                Talhao talhao = new Talhao();
                
                
                ArrayList<Doenca> doencas = new ArrayList<Doenca>();
                
		if(operacao.equals("SALVAR")){
                    int qt_doencas = Integer.parseInt(request.getParameter("qtDoencas"));
                    int id_cultura = Integer.parseInt(request.getParameter("culturaID"));
                    
                    id_talhao = Integer.parseInt(request.getParameter("talhaoID"));
                    
                    
                    cultura.setId(id_cultura);
                
                    // for para inserir todas as doencas na cultura
                    for(int i = 0; i < qt_doencas; i++){
                        Doenca doenca = new Doenca();
                        qt_perguntas = Integer.parseInt(request.getParameter("qtPergunas"+i));
                        int id_doenca =  Integer.parseInt(request.getParameter("doencaID"+i));
                        nm_doenca = request.getParameter("nmDoenca"+i);
                        doenca.setId(id_doenca);
                        ArrayList<String> respostas = new ArrayList<String>();
                        // for para pegar perguntas dentro da doenca
                        for(int y = 0; y < qt_perguntas; y++){
                             
                            // se não pegar nada, quer dizer que não é um tipo boolean, ou seja, text
                            if(nm_doenca.equals(null)){
                                String respTXT = request.getParameter("txt"+i+""+y);
                                respostas.add(respTXT);
                            }else{
                                String respBool = request.getParameter("combo"+i+""+y);
                                respostas.add(respBool);
                            }
                        }
                        
                        doenca.setRespostas(respostas);
                        doencas.add(doenca);
                    }
                    cultura.setDoencas(doencas);
                    talhao.setCultura(cultura);
                    // pegar os dados do NewDiarioJSP e jogar para ca, lembrando que Já criei a lista de perguntas no modelo Doenca!!!!
                    // Não esquecer amanhã seu retardado
                    // Termina logo essa porra!!
                    
                
                
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
                    if (request.getParameter("txtTalhao_ID") != null){
                        id_talhao  = Integer.parseInt(request.getParameter("txtTalhao_ID"));
                    }
                    
                    
                }	
		
                
                Propriedade prop = new Propriedade();
                
                talhao.setId(id_talhao);
                talhao.setPropriedade(prop);
                
                diario = new Diario();
                diario.setTalhao(talhao);
                
                
                
		
                
            
		return diario;
	}
        
     public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operacao = request.getParameter("OPERACAO");		
        Servlet servlet = new Servlet();
        
        if(operacao.equals("SALVAR")){
 
            request.setAttribute("ConsultaPropriedade", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("IndexDiario.jsp");	
            
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
            request.setAttribute("SelectTalhao2", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("NewDiario.jsp");		

            rd.forward(request, response);
        }else {
            
            String uri = request.getRequestURI();
            request.setAttribute("SelectTalhao", resultado);
            RequestDispatcher rd;
            Resultado result = (Resultado)resultado;
            List<EntidadeDominio> ls = result.getEntidades();
            
            
            if (uri.equals("/CRUD-web/SelectTalhao")){//se trazer apenas um objeto, manda para tela de editar
                rd = request.getRequestDispatcher("IndexDiario2.jsp");		
            }else if(uri.equals("/CRUD-web/SelectTalhao2")){//se trazer apenas um objeto, manda para tela de editar
                rd = request.getRequestDispatcher("NewDiario.jsp");		
            }else {
                rd = request.getRequestDispatcher("IndexPropriedade.jsp");		
            }
            
            rd.forward(request, response);
        }
    }
}
