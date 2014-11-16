package dominio;

public class PessoaFisica {
	private int idPessoaF;
	private String cpf;
	private String rg;
	private char genero;
	private Adotante adotante;
	
	
	public int getIdPessoaF() {
		return idPessoaF;
	}
	public void setIdPessoaF(int idPessoaF) {
		this.idPessoaF = idPessoaF;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public Adotante getAdotante() {
		return adotante;
	}
	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
	
	

}
