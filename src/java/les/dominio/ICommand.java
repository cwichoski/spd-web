package les.dominio;

import 	les.dominio.EntidadeDominio;;

public interface ICommand {
	  public String executar(EntidadeDominio entidade);
}
