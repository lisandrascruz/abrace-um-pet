package adotante.dominio;

public class PessoaJuridica {
	private int idPessoaJ;
	private String cnpj;
	private PessoaFisica responsavel;
	private Adotante adotante;
	
	public int getIdPessoaJ() {
		return idPessoaJ;
	}
	public void setIdPessoaJ(int idPessoaJ) {
		this.idPessoaJ = idPessoaJ;
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
