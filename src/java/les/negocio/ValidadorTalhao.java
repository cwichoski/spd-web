package les.negocio;

import les.dominio.*;
import les.util.FormataString;;

public class ValidadorTalhao implements IStrategy{
	public String processar(EntidadeDominio entidade) {
		Endereco end = (Endereco)entidade;
		StringBuilder sb = new StringBuilder();
		if(end.getRua() == null || end.getRua().trim().equals("")){
			FormataString.addString(sb, "Rua � obrigat�rio!");
		}
		
		if(end.getCidade() == null || end.getCidade().trim().equals("")){
			
			FormataString.addString(sb, "Cidade � obrigat�rio!");
		}
		
		if(end.getCep() == null || end.getCep().trim().equals("")){
			FormataString.addString(sb, "Cep � obrigat�rio!");
		}
		
		if(sb.length() != 0){
			return sb.toString();
		}		
		return null;
	}


}
