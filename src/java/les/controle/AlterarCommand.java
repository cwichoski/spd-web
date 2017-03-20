package les.controle;

import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class AlterarCommand extends AbstractCommand{

	public String executar(EntidadeDominio entidade) {
            return fachada.alterar(entidade);
	}

}
