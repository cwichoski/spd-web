package les.controle;

import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class ConsultarCommand extends AbstractCommand{

	public String executar(EntidadeDominio entidade) {
            return fachada.consultar(entidade);	}

}
