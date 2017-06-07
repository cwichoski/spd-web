/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.aplicacao;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import les.controle.ConsultarCommand;
import les.dominio.Cargo;
import les.dominio.Cultura;
import les.dominio.Doenca;
import les.dominio.EntidadeDominio;
import les.dominio.Grupo;
import les.dominio.ICommand;
import les.dominio.Propriedade;
import les.dominio.Talhao;

/**
 *
 * @author gustavo
 */
public class Lists {
    public Lists(HttpServletRequest request){
        
        ServletContext application2 = request.getServletContext();
        ICommand command = new ConsultarCommand();
         // Inicializando a lista de Cargos 
        EntidadeDominio cargo = new Cargo();
        Resultado resultCargo = command.executar(cargo);
        List<EntidadeDominio> cargos = resultCargo.getEntidades();
                
        application2.removeAttribute("Cargo");
        application2.setAttribute("Cargo", cargos);
        
        
        // Inicializando a lista de Grupos 
        EntidadeDominio grupo = new Grupo();
        Resultado resultGrupo = command.executar(grupo);  
        List<EntidadeDominio> grupos = resultGrupo.getEntidades();
        
        application2.removeAttribute("Grupo");
        application2.setAttribute("Grupo", grupos);
        
        // Inicializando a lista de Propriedades 
        EntidadeDominio prop = new Propriedade();
        Resultado resultProp = command.executar(prop);  
        List<EntidadeDominio> propriedades = resultProp.getEntidades();
        
        application2.removeAttribute("Propriedade");
        application2.setAttribute("Propriedade", propriedades);
        
        // Inicializando a lista de Talhoes
        EntidadeDominio talhao = new Talhao();
        Resultado resultTalhao = command.executar(talhao);  
        List<EntidadeDominio> talhoes = resultProp.getEntidades();
        
        application2.removeAttribute("Talhao");
        application2.setAttribute("Talhao", talhoes);

        EntidadeDominio cultura = new Cultura();
        Resultado resultCultura = command.executar(cultura);  
        List<EntidadeDominio> culturas = resultProp.getEntidades();
        
        application2.removeAttribute("Cultura");
        application2.setAttribute("Cultura", culturas);
        
        // Inicializando a lista de Culturas
        EntidadeDominio doenca = new Doenca();
        Resultado resultDoenca = command.executar(doenca);  
        List<EntidadeDominio> doencas = resultProp.getEntidades();
        
        application2.removeAttribute("Doenca");
        application2.setAttribute("Doenca", doencas);


    }
}
