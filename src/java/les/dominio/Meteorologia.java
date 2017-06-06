/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dominio;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author gustavo
 */
public class Meteorologia extends EntidadeDominio{
        
    
    private Dispositivo dispositivo;
    private double temperatura;
    private double mm_chuva;
    private int umidade;

    public int getUmidade() {
        return umidade;
    }

    public void setUmidade(int umidade) {
        this.umidade = umidade;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    private Date data;
    
    

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
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

    
    
}
