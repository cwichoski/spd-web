package les.controle;

import les.aplicacao.Resultado;
import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class ExcluirCommand extends AbstractCommand{

	public Resultado executar(EntidadeDominio entidade) {
            return fachada.excluir(entidade);
	}

}
