package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.MensagemUsuario;

public interface MensagemUsuarioDAO {

public void inserir(MensagemUsuario mensagemUsuario);
	
	public void alterar(MensagemUsuario mensagemUsuario);
	
	public MensagemUsuario recuperarByLogin(String login);
	
	public MensagemUsuario recuperarById(Long id);
	
	public void apagar(MensagemUsuario mensagemUsuario);
	
}
