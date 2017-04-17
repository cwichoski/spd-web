package les.dominio;

import java.util.Date;

public class Funcionario extends Pessoa{
    public Funcionario(String nome, String cpf, Endereco end, Date dt_nasc, Grupo gp, Cargo ca){
        super(nome, cpf, end, dt_nasc);
        this.cargo = ca;
        this.grupo = gp;

    }

    public Funcionario(){

    }

    private Grupo grupo;
    private Cargo cargo;

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
