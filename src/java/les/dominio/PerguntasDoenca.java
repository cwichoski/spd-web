 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package les.dominio;

/**
 *
 * @author gustavo
 */
public class PerguntasDoenca extends EntidadeDominio{
    
    public PerguntasDoenca(){
        
    }
    
    public PerguntasDoenca(String descricao, int id){
        this.descricao = descricao;
        super.setId(id);
    }
    
    private String descricao;
    private String tipo;
    private int ordem;

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
