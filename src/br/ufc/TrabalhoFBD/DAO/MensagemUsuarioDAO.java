package br.ufc.TrabalhoFBD.DAO;

import java.util.List;

import br.ufc.TrabalhoFBD.model.MensagemUsuario;
import br.ufc.TrabalhoFBD.model.Usuario;

public interface MensagemUsuarioDAO {

public void inserir(MensagemUsuario mensagemUsuario);
	
	public MensagemUsuario recuperarById(Long id);
	
	public List<MensagemUsuario> getMensagensUsuario(Usuario usuario);
	
	public Usuario getRemetente(Long idMensagem);
	
	public Usuario getDestinatario(Long idMensagem);
}
