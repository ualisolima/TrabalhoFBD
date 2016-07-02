package br.ufc.TrabalhoFBD.model;
//Como List não é um tipo primitivo ele precisa importar da biblioteca padrao
import java.util.List;

public class Endereco {
	
	private String cep ;
	private String pais;
	private String cidade;
	private String rua;
	private String estado;
	//essa entidade tem uma relação de 1 pra N com usuario, e em orientacao a objeto a gente representa essa relação com uma lista na entidade que possui
	//Lista do tipo usuario
	private List<Usuario> usuarios;
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}
