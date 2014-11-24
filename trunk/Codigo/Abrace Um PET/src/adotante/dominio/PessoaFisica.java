package adotante.dominio;

public class PessoaFisica {
	private int id;
	private String cpf;
	private String rg;
	private String genero;
	private Adotante adotante;
	
	
	public int getId() {
		return id;
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Adotante getAdotante() {
		return adotante;
	}
	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
	
	

}
