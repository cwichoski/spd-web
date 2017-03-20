/*
 * QUADRANS TECNOLOGIA;
 * TODO Produto $(product_name} - ${product_description}<br>
 *
 * Data de Cria��o: 24/11/2016<br>
 * <br>
 * Todos os direitos reservados.
 */

package les.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les.dominio.EntidadeDominio;

/** 
 * DOCUMENTA��O DA CLASSE <br>
 * ---------------------- <br>
 * FINALIDADE: <br>
 * TODO Definir documenta��o da classe. <br>
 * <br>
 * HIST�RICO DE DESENVOLVIMENTO: <br>
 * 24/11/2016 - @author Rodrigo Rocha Silva - Primeiva vers�o da classe. <br>
 *<br>
 *<br>
 * LISTA DE CLASSES INTERNAS: <br>
 */

public interface IViewHelper {

public EntidadeDominio getEntidade(HttpServletRequest request);
	
	public void setView(Object resultado, 
			HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException;
}
