package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.Telefone;

public interface TelefoneDAO {

public void inserir(Telefone telefone);
	
	public void alterar(Telefone telefone);
	
	public Telefone recuperarByLogin(String login);
	
	public Telefone recuperarById(Long id);
	
	public void apagar(Telefone telefone);
	
}
