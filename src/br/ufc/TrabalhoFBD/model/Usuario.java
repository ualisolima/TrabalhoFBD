package br.ufc.TrabalhoFBD.model;

import java.util.List;

public class Usuario {
	
	private Long idUsuario;
	private String login;
	private String senha;
	private String pNome;
	private String mNome;
	private String uNome;
	//Na tabela que é "possuida" pela entidade mais forte, a entidade vira um objeto comum;
	private Endereco endereco;
	private String nCasa;
	//Usuario possui vários telefones
	private List<Telefone> telefones;
	//Usuario possui vários logs
	private List<Log> logins;
	//Usuario possui vários amigos
	private List<Usuario> amigos;
	//lista de grupos que ele administra;
	private List<Grupo> gruposAdm;
	//lista de grupos que ele participa;
	private List<Grupo> grupoParticipa;
	//Lista de mensagens
	private List<MensagemUsuario> mensagens;
	
	public List<MensagemUsuario> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<MensagemUsuario> mensagens) {
		this.mensagens = mensagens;
	}

	public List<Grupo> getGrupoParticipa() {
		return grupoParticipa;
	}

	public void setGrupoParticipa(List<Grupo> grupoParticipa) {
		this.grupoParticipa = grupoParticipa;
	}

	public List<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}

	public List<Grupo> getGruposAdm() {
		return gruposAdm;
	}

	public void setGruposAdm(List<Grupo> gruposAdm) {
		this.gruposAdm = gruposAdm;
	}

	public List<Log> getLogins() {
		return logins;
	}

	public void setLogins(List<Log> logins) {
		this.logins = logins;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getLogin(){
		return this.login;
	}
	
	public void setLogin(String login){
		this.login = login;
	}
	
	public String getSenha(){
		return this.senha;
	}
	
	public void setSenha(String senha){
		this.senha = senha;
	}

	public String getpNome() {
		return pNome;
	}

	public void setpNome(String pNome) {
		this.pNome = pNome;
	}

	public String getmNome() {
		return mNome;
	}

	public void setmNome(String mNome) {
		this.mNome = mNome;
	}

	public String getuNome() {
		return uNome;
	}

	public void setuNome(String uNome) {
		this.uNome = uNome;
	}
	
	public String getnCasa() {
		return nCasa;
	}

	public void setnCasa(String nCasa) {
		this.nCasa = nCasa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}
