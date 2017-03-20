package les.controle;

import javax.servlet.http.HttpServletRequest;
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
                }	
		/*}else if(operacao.equals("EXCLUIR")){		
			cpf = args[1];			
		}else if(operacao.equals("CONSULTAR") && args[0] != null){		
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
}
