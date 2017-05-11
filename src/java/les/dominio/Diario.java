/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author gustavo
 */
public class Diario extends EntidadeDominio{
        
    
    boolean apresenta_mancha;
    private double temperatura;
    private double mm_chuva;
    private Talhao talhao;
    

    public boolean isApresenta_mancha() {
        return apresenta_mancha;
    }

    public void setApresenta_mancha(boolean apresenta_mancha) {
        this.apresenta_mancha = apresenta_mancha;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getMm_chuva() {
        return mm_chuva;
    }

    public void setMm_chuva(double mm_chuva) {
        this.mm_chuva = mm_chuva;
    }

    public Talhao getTalhao() {
        return talhao;
    }

    public void setTalhao(Talhao talhao) {
        this.talhao = talhao;
    }
}
