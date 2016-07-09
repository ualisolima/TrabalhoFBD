package br.ufc.TrabalhoFBD.DAO;

import java.util.List;

import br.ufc.TrabalhoFBD.model.Grupo;
import br.ufc.TrabalhoFBD.model.Usuario;

public interface GrupoDAO {

public void inserir(Grupo grupo);
	
	public boolean alterar(Grupo grupo);
	
	public Grupo recuperarById(Long idGrupo);
	
	public boolean apagar(Grupo grupo);
	
	public List<Grupo> getGrupos(Usuario usuario);
	
	public List<Usuario> getUsuarios(Long idGrupo);
	
	public List<Grupo> getGruposAdm(Usuario usuario);
}
