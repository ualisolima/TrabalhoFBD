package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.MensagemGrupo;

public interface MensagemGrupoDAO {

public void inserir(MensagemGrupo mensagemGrupo);
	
	public void alterar(MensagemGrupo mensagemGrupo);
	
	public MensagemGrupo recuperarByLogin(String login);
	
	public MensagemGrupo recuperarById(Long id);
	
	public void apagar(MensagemGrupo mensagemGrupo);
	
}
