/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dominio;

import java.util.Date;



/**
 *
 * @author gustavo
 */
public class Talhao extends EntidadeDominio{
        
    public Talhao(){
        
    }
    
    public Talhao(String descricao, int id){
        this.descricao = descricao;
        super.setId(id);
    }
    
    private String descricao;
    private String cultura;
    private double hectares;
    private Propriedade propriedade;

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public double getHectares() {
        return hectares;
    }

    public void setHectares(double hectares) {
        this.hectares = hectares;
    }

    public Date getDt_ultima_colheita() {
        return dt_ultima_colheita;
    }

    public void setDt_ultima_colheita(Date dt_ultima_colheita) {
        this.dt_ultima_colheita = dt_ultima_colheita;
    }

    public String getTipo_terra() {
        return tipo_terra;
    }

    public void setTipo_terra(String tipo_terra) {
        this.tipo_terra = tipo_terra;
    }
    private Date dt_ultima_colheita;
    private String tipo_terra;
   
   
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
