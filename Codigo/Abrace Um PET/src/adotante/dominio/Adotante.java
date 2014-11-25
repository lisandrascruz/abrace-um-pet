package adotante.dominio;

public class Adotante {
	private int id;
	private PessoaFisica pessoaFisica;
	private PessoaJuridica pessoaJuridica;
	private boolean impedimento;
	private String motivoImpedimento;

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public boolean isImpedimento() {
		return impedimento;
	}

	public void setImpedimento(boolean impedimento) {
		this.impedimento = impedimento;
	}

	public String getMotivoImpedimento() {
		return motivoImpedimento;
	}

	public void setMotivoImpedimento(String motivoImpedimento) {
		this.motivoImpedimento = motivoImpedimento;
	}

	public int getId() {
		return id;
	}

}
