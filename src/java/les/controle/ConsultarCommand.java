package les.controle;

import java.util.List;
import les.aplicacao.Resultado;
import les.dominio.EntidadeDominio;
import les.dominio.ICommand;

public class ConsultarCommand extends AbstractCommand{

        @Override
        public Resultado executar(EntidadeDominio entidade) {
            return fachada.consultar(entidade);	
        }

        
        public Resultado executar2(EntidadeDominio entidade) {
            return fachada.consultar(entidade);	
        }

}
