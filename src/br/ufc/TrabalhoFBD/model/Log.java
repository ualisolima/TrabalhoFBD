package br.ufc.TrabalhoFBD.model;
//Como timestamp não é do tipo primitivo ele precisa importar da biblioteca padrão
import java.sql.Timestamp;

public class Log {
	
	private Long idLog;
	private Long idUsuario;
	private Timestamp dataHorario;
	//Log pertence a um usuario
	private Usuario usuario;
	
	public Long getIdLog() {
		return idLog;
	}
	public void setIdLog(Long idLog) {
		this.idLog = idLog;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Timestamp getDataHorario() {
		return dataHorario;
	}
	public void setDataHorario(Timestamp dataHorario) {
		this.dataHorario = dataHorario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
