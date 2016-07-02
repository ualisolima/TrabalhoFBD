package br.ufc.TrabalhoFBD.model;

import java.sql.Timestamp;

public abstract class Mensagem {
	
	private Long idMensagem;
	private Long idRemetente;
	private Usuario remetente;
	private Long idDestinatario;
	private Timestamp dataHoraEnvio;
	public Long getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(Long idMensagem) {
		this.idMensagem = idMensagem;
	}
	public Long getIdRemetente() {
		return idRemetente;
	}
	public void setIdRemetente(Long idRemetente) {
		this.idRemetente = idRemetente;
	}
	public Usuario getRemetente() {
		return remetente;
	}
	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}
	public Long getIdDestinatario() {
		return idDestinatario;
	}
	public void setIdDestinatario(Long idDestinatario) {
		this.idDestinatario = idDestinatario;
	}
	public Timestamp getDataHoraEnvio() {
		return dataHoraEnvio;
	}
	public void setDataHoraEnvio(Timestamp dataHoraEnvio) {
		this.dataHoraEnvio = dataHoraEnvio;
	}
	
	

}
