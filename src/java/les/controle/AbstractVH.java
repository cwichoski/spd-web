package les.controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les.dominio.EntidadeDominio;

public class AbstractVH implements IViewHelper{
	
	protected String operacao;	
	private String nmEntidade;
	
	public AbstractVH (String nmEntidade){
		this.nmEntidade = nmEntidade;
	}

	public void setView(Object resultado, String response) throws IOException{
		//PrintWriter out = response.getWriter();
		
		if(resultado != null){
			System.out.println(resultado.toString());
		}		

	}

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
