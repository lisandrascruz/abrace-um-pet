package adotante.adotante;

public class PessoaJuridica {
	private int id;
	private String cnpj;
	private PessoaFisica responsavel;
	private Adotante adotante;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public PessoaFisica getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(PessoaFisica responsavel) {
		this.responsavel = responsavel;
	}
	public Adotante getAdotante() {
		return adotante;
	}
	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}
	
	
}
