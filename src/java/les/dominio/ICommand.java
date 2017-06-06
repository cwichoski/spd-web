package les.dominio;

import les.aplicacao.Resultado;
import 	les.dominio.EntidadeDominio;;

public interface ICommand<T> {

    /**
     *
     * @param entidade
     * @return
     */
    public Resultado executar(EntidadeDominio entidade);
}
