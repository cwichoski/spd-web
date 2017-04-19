/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.aplicacao;

import java.util.List;
import les.dominio.EntidadeDominio;

/**
 *
 * @author gustavo
 */
public class Resultado {
    private String msg;
    private List<EntidadeDominio> entidades;
    private List<EntidadeDominio> propriedades;
    private List<EntidadeDominio> cargos;
    private List<EntidadeDominio> grupos;
    
    
    public List<EntidadeDominio> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<EntidadeDominio> propriedades) {
        this.propriedades = propriedades;
    }

    public List<EntidadeDominio> getCargos() {
        return cargos;
    }

    public void setCargos(List<EntidadeDominio> cargos) {
        this.cargos = cargos;
    }

    public List<EntidadeDominio> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<EntidadeDominio> grupos) {
        this.grupos = grupos;
    }

    /**
     * M�todo de recupera��o do campo msg
     *
     * @return valor do campo msg
     */
    public String getMsg() {
            return msg;
    }
    /**
     * Valor de msg atribu�do a msg
     *
     * @param msg Atributo da Classe
     */
    public void setMsg(String msg) {
            this.msg = msg;
    }
    /**
     * M�todo de recupera��o do campo entidades
     *
     * @return valor do campo entidades
     */
    public List<EntidadeDominio> getEntidades() {
            return entidades;
    }
    /**
     * Valor de entidades atribu�do a entidades
     *
     * @param entidades Atributo da Classe
     */
    public void setEntidades(List<EntidadeDominio> entidades) {
            this.entidades = entidades;
    }



	
}
