package les.controle;

import java.util.List;
import les.aplicacao.Resultado;
import les.dominio.EntidadeDominio;

public interface IFachada {

	public Resultado salvar(EntidadeDominio entidade);
	public Resultado alterar(EntidadeDominio entidade);
	public Resultado excluir(EntidadeDominio entidade);
	public Resultado consultar(EntidadeDominio entidade);	
}
