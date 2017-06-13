/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.controle;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import les.aplicacao.Resultado;
import les.dominio.Arquivo;
import les.dominio.EntidadeDominio;

/**
 *
 * @author gustavo
 */
class ArquivoVH extends AbstractVH {

    public ArquivoVH(){
		super("Diario");
	}
	
	
	public EntidadeDominio getEntidade(HttpServletRequest request) {
            Arquivo arquivo = new Arquivo();
            try {
                operacao = request.getParameter("OPERACAO");
                Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
                InputStream fileContent = filePart.getInputStream();
                String caminhao = "/home/gustavo/Documents/weka";
                String nm_arquivo = null;
                
                for (String cd : filePart.getHeader("content-disposition").split(";")) {
                    if (cd.trim().startsWith("filename")) {
                        nm_arquivo = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                    }
		}
                

                if(operacao.equals("SALVAR")){
                    arquivo.setNomeDoArquivo(nm_arquivo);
                    //arquivo.setId(Integer.parseInt(request.getParameter("doencaID")));
                    arquivo.upload(caminhao, nm_arquivo, fileContent);
                    
                    

                }else if(operacao.equals("EXCLUIR")){

                }else if(operacao.equals("CONSULTAR") ){
                    arquivo.setNomeDoArquivo(nm_arquivo);
                    //arquivo.setId(Integer.parseInt(request.getParameter("doencaID")));
                    arquivo.upload(caminhao, nm_arquivo, fileContent);
        

                }else if(operacao.equals("EDITAR")){

                }else if(operacao.equals("NOVO")){

                }

                } catch (IOException ex) {
                    Logger.getLogger(ArquivoVH.class.getName()).log(Level.SEVERE, null, ex);

                } catch (IllegalStateException ex) {
                    Logger.getLogger(ArquivoVH.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServletException ex) {
                    Logger.getLogger(ArquivoVH.class.getName()).log(Level.SEVERE, null, ex);
                }
                return arquivo;
	}
        
     public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operacao = request.getParameter("OPERACAO");		
        Servlet servlet = new Servlet();
        
        if(operacao.equals("SALVAR")){
 
            request.setAttribute("ConsultaPropriedade", resultado);
            //RequestDispatcher rd = request.getRequestDispatcher("IndexDiario.jsp");	
            Resultado result = (Resultado)resultado;

            List<EntidadeDominio> arquivos = (List<EntidadeDominio>) result.getEntidades();    

            Arquivo arquivo = (Arquivo)arquivos.get(0);
            String json = new Gson().toJson(arquivo);

            response.setContentType("application/json");
            response.getWriter().write(json);
            
            /*servlet.init(request);
            rd.forward(request, response);*/
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
            
 
            
            //RequestDispatcher rd = request.getRequestDispatcher("IndexDiario.jsp");	
            
            
            

            
            request.setAttribute("SelectArquivo", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("NewDoenca2.jsp");		

            rd.forward(request, response);
        }
    }
}
