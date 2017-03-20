package les.dominio;


public class Pessoa extends EntidadeDominio{

	private String nome;
	private String cpf;
	private String dt_nasc;

	private Endereco end;
	
	public Pessoa(){}
	
	public Pessoa(String nome){
		this.nome = nome;
	}
	
	public Pessoa(String nome, String cpf,
			Endereco end, String dt_nasc){
		this.nome = nome;
		this.cpf = cpf;
		this.dt_nasc = dt_nasc;
		this.end = end;
	}
	
		
	public String getNome() {		
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Endereco getEnd() {
		return end;
	}
	public void setEnd(Endereco end) {
		this.end = end;
	}

	public String getDt_nasc() {
		return dt_nasc;
	}

	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
			
}



