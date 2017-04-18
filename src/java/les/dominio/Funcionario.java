package les.dominio;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funcionario extends Pessoa{
    public Funcionario(String nome, String cpf, Endereco end, Date dt_nasc, int gp, int ca){
        super(nome, cpf, end, dt_nasc);
        this.cargo_id = ca;
        this.grupo_id = gp;

    }

    public Funcionario(){

    }

    private int cargo_id;
    private int grupo_id;
    private List<EntidadeDominio> cargos ;
    private List<EntidadeDominio> grupos ;

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }

    public int getGrupo_id() {
        return grupo_id;
    }

    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
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
    
    
   
}