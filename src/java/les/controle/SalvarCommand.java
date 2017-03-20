package les.controle;

import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class SalvarCommand extends AbstractCommand{
    
    public String executar(EntidadeDominio entidade) {
        return fachada.salvar(entidade);
    }

}
