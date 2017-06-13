package les.negocio;

import les.dominio.Funcionario;
import les.dominio.Endereco;
import les.dominio.EntidadeDominio;
import les.util.FormataString;


public class ValidadorFuncionario implements IStrategy{
	public String processar(EntidadeDominio entidade) {		
//		Funcionario funcionario= (Funcionario)entidade;
//		
//		String nome = funcionario.getNome();
//		String cpf = funcionario.getCpf();
//		Endereco end = funcionario.getEnd();		
//		
//		StringBuilder sb = new StringBuilder();
//		if(nome == null && nome.trim().equals("")){
//			FormataString.addString(sb, "Nome � obrigat�rio!");
//		}
//		
//		if(cpf == null && cpf.trim().equals("")){
//			
//			FormataString.addString(sb, "CPF � obrigat�rio!");
//		}
//		
//		if(end == null){
//			FormataString.addString(sb, "Endere�o � obrigat�rio!");
//		}else{
//			ValidadorEndereco validadorEnd = new ValidadorEndereco();
//			String vEnd = validadorEnd.processar(end);
//			if(vEnd != null){
//				FormataString.addString(sb, vEnd);
//			}
//		}
//		
//		if(sb.length() != 0){
//			return sb.toString();
//		}		
//					
//		
//		if(sb.length() != 0){
//			return sb.toString();
//		}	
		return null;
	}


}
