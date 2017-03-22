package les.dominio;

import 	les.dominio.EntidadeDominio;;

public interface ICommand<T> {

    /**
     *
     * @param entidade
     * @return
     */
    public T executar(EntidadeDominio entidade);
}
