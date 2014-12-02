package adotante.dominio;

public class Endereco {
	
	private int id;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String cep;
	private String complemento;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}	
	public String formarEndereco(){
		String endereco = getRua() + ", " + getNumero()+", "+ getBairro()+", "+ getCep()+", "+ ", "+getCidade()+"("+getEstado()+")";
		return endereco;
	}
}