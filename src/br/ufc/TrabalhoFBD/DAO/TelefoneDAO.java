package br.ufc.TrabalhoFBD.DAO;

import java.util.List;

import br.ufc.TrabalhoFBD.model.Telefone;
import br.ufc.TrabalhoFBD.model.Usuario;

public interface TelefoneDAO {

public void inserir(Telefone telefone);
	
	public boolean alterar(Telefone telefone);
	
	public Telefone recuperarById(Usuario usuario, String telefone);
	
	public List<Telefone> getTelefones(Usuario usuario);
	
	public boolean apagar(Telefone telefone);
	
}
