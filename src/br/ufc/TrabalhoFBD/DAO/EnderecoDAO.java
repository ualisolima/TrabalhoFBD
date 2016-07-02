package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.Endereco;

public interface EnderecoDAO {

public void inserir(Endereco endereco);
	
	public void alterar(Endereco endereco);
	
	public Endereco recuperarByLogin(String login);
	
	public Endereco recuperarById(Long id);
	
	public void apagar(Endereco endereco);
	
}
