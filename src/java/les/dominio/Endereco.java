package les.dominio;

public class Endereco extends EntidadeDominio{
	
	/** Atributo que representa a rua do ende�o **/
	private String rua;
	private String cep;
	private String cidade;
	
	/**
	 * Construtor padr�o para defini��o de um endere�o completo
	 * @param rua - Rua do Endere�o criado
	 * @param cep - Cep do Endere�o criado
	 * @param cidade - Cidade do Endere�o criado
	 */

	public Endereco(String rua, String cep, String cidade) {
		this.rua = rua;
		this.cep = cep;
		this.cidade = cidade;
	}

	/**
	 * M�todo de acesso para obter uma rua;
	 * @return retorna a rua do endere�o
	 */
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
