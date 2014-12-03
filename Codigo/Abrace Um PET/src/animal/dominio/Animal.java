package animal.dominio;

import sun.util.calendar.BaseCalendar.Date;

public class Animal {
	
	private int id;
	private String nome;
	private String tipo;
	private String rga;
	private java.sql.Date dataNascimento;	
	private Raca raca;
	private String genero;
	private String deficiencia;
	private boolean vacinado;
	private boolean castrado;
	private double tamanho;
	private double peso;
	private String temperamento;
	private String observacao;
	private java.sql.Date dataResgate;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRga() {
		return rga;
	}
	public void setRga(String rga) {
		this.rga = rga;
	}
	public java.sql.Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(java.sql.Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Raca getRaca() {
		return raca;
	}
	public void setRaca(Raca raca) {
		this.raca = raca;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDeficiencia() {
		return deficiencia;
	}
	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}
	public boolean isVacinado() {
		return vacinado;
	}
	public void setVacinado(boolean vacinado) {
		this.vacinado = vacinado;
	}
	public boolean isCastrado() {
		return castrado;
	}
	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getTemperamento() {
		return temperamento;
	}
	public void setTemperamento(String temperamento) {
		this.temperamento = temperamento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public java.sql.Date getDataResgate() {
		return dataResgate;
	}
	public void setDataResgate(java.sql.Date dataResgate) {
		this.dataResgate = dataResgate;
	}
	public int getId() {
		return id;
	}
//	public void setDataResgate(java.sql.Date date) {
//		// TODO Auto-generated method stub
//		
//	}
//	public void setDataNascimento(java.sql.Date date) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
}