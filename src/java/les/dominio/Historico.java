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
public class Historico extends EntidadeDominio{
        
    public Historico(){
        
    }
    
    public Historico(int id){
        super.setId(id);
    }
    
    private Date data;
    private int pct_doenca;
    private Talhao talhao;
    private Doenca doenca;

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }
    

    public Talhao getTalhao() {
        return talhao;
    }

    public void setTalhao(Talhao talhao) {
        this.talhao = talhao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPct_doenca() {
        return pct_doenca;
    }

    public void setPct_doenca(int pct_doenca) {
        this.pct_doenca = pct_doenca;
    }
    
    
}
