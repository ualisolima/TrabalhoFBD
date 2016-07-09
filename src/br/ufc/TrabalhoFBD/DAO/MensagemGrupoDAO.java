package br.ufc.TrabalhoFBD.DAO;

import java.util.List;

import br.ufc.TrabalhoFBD.model.Grupo;
import br.ufc.TrabalhoFBD.model.MensagemGrupo;
import br.ufc.TrabalhoFBD.model.Usuario;

public interface MensagemGrupoDAO {

public void inserir(MensagemGrupo mensagemGrupo);
	
	public MensagemGrupo recuperarById(Long id);
	
	public List<MensagemGrupo> getMensagensGrupo(Grupo grupo);
	
	public Usuario getRemetente(Long idMensagem);

	
}
