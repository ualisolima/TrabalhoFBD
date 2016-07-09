package br.ufc.TrabalhoFBD.model;

import java.sql.Date;
import java.util.List;

public class Grupo {
	
	private Long idGrupo;
	private String nomeGrupo;
	private Date dtCriacao;
	private Usuario amd;
	private List<Usuario> usuarios;
	//List de mensagens em grupo
	private List<MensagemGrupo> mensagensGrupo;
	
	public List<MensagemGrupo> getMensagensGrupo() {
		return mensagensGrupo;
	}
	public void setMensagensGrupo(List<MensagemGrupo> mensagensGrupo) {
		this.mensagensGrupo = mensagensGrupo;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	public Date getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public Usuario getAmd() {
		return amd;
	}
	public void setAmd(Usuario amd) {
		this.amd = amd;
	}
	

}
