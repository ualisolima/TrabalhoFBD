package br.ufc.TrabalhoFBD.model;

import java.sql.Timestamp;

public abstract class Mensagem {
	
	private Long idMensagem;
	private Usuario remetente;
	private Timestamp dataHoraEnvio;
	private String corpo; 
	
	
	
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
	public Long getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}
	
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	
	public Timestamp getDataHoraEnvio() {
		return dataHoraEnvio;
	}
	public void setDataHoraEnvio(Timestamp dataHoraEnvio) {
		this.dataHoraEnvio = dataHoraEnvio;
	}
	
	

}
