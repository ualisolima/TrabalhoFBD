package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.Amigo;

public interface AmigoDAO {
	
public void inserir(Amigo usuario);
	
	public void alterar(Amigo usuario);
	
	public Amigo recuperarByLogin(String login);
	
	public Amigo recuperarById(Long id);
	
	public void apagar(Amigo usuario);

}
