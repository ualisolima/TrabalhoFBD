package br.ufc.TrabalhoFBD.DAO;

import br.ufc.TrabalhoFBD.model.Usuario;

public interface UsuarioDAO {
	
	public void inserir(Usuario usuario);
	
	public boolean alterar(Usuario usuario);
	
	public Usuario recuperarByLogin(String login);
	
	public Usuario recuperarById(Long id);
	
	public boolean apagar(Usuario usuario);

}
