package les.controle;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import les.dominio.Funcionario;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;

public class FuncionarioVH extends AbstractVH{
	public FuncionarioVH(){
		super("Funcionario");
	}
	
	
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		operacao = request.getParameter("OPERACAO");		
		int id=0;
		String nome=null;	
		String cpf=null;
		String dt_nasc = null;
		String rua=null;
		String cep=null;
		String cidade=null;
		Endereco end=null;
		
		if(operacao.equals("SALVAR")){
			
                    nome = request.getParameter("txtNome");
                    cpf = request.getParameter("txtCpf");
                    dt_nasc = request.getParameter("txtDtNasc");
                    rua = request.getParameter("txtRua");
                    cep = request.getParameter("txtCep");
                    cidade = request.getParameter("txtCidade");			
                    end = new Endereco(rua, cep, cidade);
                
		}else if(operacao.equals("EXCLUIR")){		
			id  = Integer.parseInt(request.getParameter("txtID"));
                }
		/*}else if(operacao.equals("CONSULTAR") && args[0] != null){		
                    id = Integer.parseInt(args[0]);			
		}else if(operacao.equals("ALTERAR")){
                    //id = Integer.parseInt(args[9]);
                    nome = request.getParameter("txtNome");
                    cpf = request.getParameter("txtCpf");
                    dt_nasc = request.getParameter("txtDtNasc");
                    rua = request.getParameter("txtRua");
                    cep = request.getParameter("txtCep");
                    cidade = request.getParameter("txtCidade");			
                    end = new Endereco(rua, cep, cidade);			
                }	
		*/
		Funcionario funcionario = new Funcionario(nome, cpf, end, dt_nasc);
		funcionario.setId(id);
		
		return funcionario;
	}
        
     public void setView(Object resultado, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        operacao = request.getParameter("OPERACAO");		
        
        if(operacao.equals("SALVAR")){
 
            request.setAttribute("NewFuncionario", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("NewFuncionario.jsp");		

            rd.forward(request, response);
        } else if(operacao.equals("EXCLUIR")){
            
            request.setAttribute("DeleteFuncionario", resultado);
            RequestDispatcher rd = request.getRequestDispatcher("DeleteFuncionario.jsp");		

            rd.forward(request, response);
        }
    }
}
