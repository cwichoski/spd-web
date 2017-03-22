package les.controle;

import java.util.List;
import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class ConsultarCommand extends AbstractCommand{


        
        public List<EntidadeDominio> executar2(EntidadeDominio entidade) {
            return fachada.consultar(entidade);	
        }

}
