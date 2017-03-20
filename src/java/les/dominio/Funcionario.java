package les.dominio;

public class Funcionario extends Pessoa{
	public Funcionario(String nome, String cpf, Endereco end, String dt_nasc){
		super(nome, cpf, end, dt_nasc);
		this.cargo = cargo;
		
	}
	
	private String cargo;

	/**
	 * M�todo de recupera��o do campo cargo
	 *
	 * @return valor do campo cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Valor de cargo atribu�do a cargo
	 *
	 * @param cargo Atributo da Classe
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
