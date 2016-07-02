package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.Grupo;

public interface GrupoDAO {

public void inserir(Grupo grupo);
	
	public void alterar(Grupo grupo);
	
	public Grupo recuperarByLogin(String login);
	
	public Grupo recuperarById(Long id);
	
	public void apagar(Grupo grupo);
	
}
