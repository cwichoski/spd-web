package les.controle;

import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class ExcluirCommand extends AbstractCommand{

	public String executar(EntidadeDominio entidade) {
            return fachada.excluir(entidade);
	}

}
