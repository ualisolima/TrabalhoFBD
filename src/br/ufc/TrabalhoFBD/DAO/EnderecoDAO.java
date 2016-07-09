package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.Endereco;

public interface EnderecoDAO {

public void inserir(Endereco endereco);
	
	public Endereco recuperarById(String cep, String pais);
	
	public boolean apagar(Endereco endereco);
	
}
