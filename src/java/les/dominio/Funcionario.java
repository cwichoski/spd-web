package les.dominio;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Funcionario extends Pessoa{
    public Funcionario(String nome, String cpf, Endereco end, Date dt_nasc, int gp, int ca, List<Integer> pp_id){
        super(nome, cpf, end, dt_nasc);
        this.propriedades_id = new ArrayList<Integer>();
        this.cargo_id = ca;
        this.grupo_id = gp;
        this.propriedades_id = pp_id;

    }

    public Funcionario(){
        this.propriedades_id = new ArrayList<Integer>();

    }

    private int cargo_id;
    private int grupo_id;
    private List<Integer> propriedades_id;
    private List<EntidadeDominio> cargos ;
    private List<EntidadeDominio> grupos ;
    private List<EntidadeDominio> propiedades ;

    public List<EntidadeDominio> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<EntidadeDominio> propiedades) {
        this.propiedades = propiedades;
    }

    public List<Integer> getPropriedades_id() {
        return propriedades_id;
    }

    public void setPropriedades_id(Integer pp_id) {
        this.propriedades_id.add(pp_id);
    }

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