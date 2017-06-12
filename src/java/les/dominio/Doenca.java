 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class Doenca extends EntidadeDominio{
    
    public Doenca(){
        
    }
    
    public Doenca(String descricao, int id){
        this.descricao = descricao;
        super.setId(id);
    }
    
    private String descricao;
    private Arquivo arquivo;
    private List<PerguntasDoenca> perguntasDoencas = new ArrayList<PerguntasDoenca>();
    private ArrayList<String> respostas = new ArrayList<String>();
    private int pct_doenca; 

    public int getPct_doenca() {
        return pct_doenca;
    }

    public void setPct_doenca(int pct_doenca) {
        this.pct_doenca = pct_doenca;
    }

    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public List<PerguntasDoenca> perguntasDoencas() {
        return perguntasDoencas;
    }

    public void setDoencas(List<PerguntasDoenca> perguntasDoencas) {
        this.perguntasDoencas = perguntasDoencas;
    }
    

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
