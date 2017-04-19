package les.controle;

import les.aplicacao.Resultado;
import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class SalvarCommand extends AbstractCommand{
    
    @Override
    public Resultado executar(EntidadeDominio entidade) {
        return fachada.salvar(entidade);
    }

}
