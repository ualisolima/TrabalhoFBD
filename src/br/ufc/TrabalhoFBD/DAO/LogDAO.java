package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.Log;

public interface LogDAO {

public void inserir(Log log);
	
public Log recuperarById(Long id);
		
}
