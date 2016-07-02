package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.Log;

public interface LogDAO {

public void inserir(Log log);
	
	public void alterar(Log log);
	
	public Log recuperarByLogin(String login);
	
	public Log recuperarById(Long id);
	
	public void apagar(Log log);
	
}
