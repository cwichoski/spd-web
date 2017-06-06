package les.controle;

import les.aplicacao.Resultado;
import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class AlterarCommand extends AbstractCommand{

	public Resultado executar(EntidadeDominio entidade) {
            return fachada.alterar(entidade);
	}

}
