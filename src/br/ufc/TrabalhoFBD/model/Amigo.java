package br.ufc.TrabalhoFBD.model;

import java.sql.Date;

public class Amigo {
	
	private Long idUsuario1;
	private Long idUsuario2;
	private Usuario usuario1;
	private Usuario usuario2;
	private Date desde;
	public Long getIdUsuario1() {
		return idUsuario1;
	}
	public void setIdUsuario1(Long idUsuario1) {
		this.idUsuario1 = idUsuario1;
	}
	public Long getIdUsuario2() {
		return idUsuario2;
	}
	public void setIdUsuario2(Long idUsuario2) {
		this.idUsuario2 = idUsuario2;
	}
	public Usuario getUsuario1() {
		return usuario1;
	}
	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}
	public Usuario getUsuario2() {
		return usuario2;
	}
	public void setUsuario2(Usuario usuario2) {
		this.usuario2 = usuario2;
	}
	public Date getDesde() {
		return desde;
	}
	public void setDesde(Date desde) {
		this.desde = desde;
	}
	
	

}
