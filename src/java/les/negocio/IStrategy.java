package les.negocio;

import les.dominio.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade);

}
