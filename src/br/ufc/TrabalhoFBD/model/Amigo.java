package br.ufc.TrabalhoFBD.model;

import java.sql.Date;

public class Amigo {
	
	private Usuario usuario1;
	private Usuario usuario2;
	private Date desde;
	
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
