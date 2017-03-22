/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.controle;

import les.controle.Fachada;
import les.controle.IFachada;
import les.dominio.EntidadeDominio;
import les.dominio.ICommand;
 

/**
 *
 * @author giter
 */
public abstract class AbstractCommand implements ICommand{
     protected IFachada fachada = new Fachada();
     
     	public String executar(EntidadeDominio entidade) {
            return null;
        }
}

