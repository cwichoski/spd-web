/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dominio;

import java.util.ArrayList;

/**
 *
 * @author gustavo
 */
public class Cultura extends EntidadeDominio{
    
    public Cultura(){
        
    }
    
    public Cultura(String descricao, int id){
        this.descricao = descricao;
        super.setId(id);
    }
    
    private String descricao;
    private ArrayList<Doenca> doencas;

    public ArrayList<Doenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(ArrayList<Doenca> doencas) {
        this.doencas = doencas;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
