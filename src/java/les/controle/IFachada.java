package les.controle;

import les.dominio.EntidadeDominio;

public interface IFachada {

	public String salvar(EntidadeDominio entidade);
	public String alterar(EntidadeDominio entidade);
	public String excluir(EntidadeDominio entidade);
	public String consultar(EntidadeDominio entidade);	
}
