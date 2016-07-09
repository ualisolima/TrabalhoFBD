package br.ufc.TrabalhoFBD.DAO;

import java.util.List;

import br.ufc.TrabalhoFBD.model.Amigo;
import br.ufc.TrabalhoFBD.model.Usuario;

public interface AmigoDAO {
	
public void inserir(Amigo amigo);
	
	public List<Usuario> getAmigos(Usuario usuario);
	
	public boolean apagar(Amigo amigo);

}
