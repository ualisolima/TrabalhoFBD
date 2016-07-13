package br.ufc.TrabalhoFBD.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.TrabalhoFBD.DAO.GrupoDAO;
import br.ufc.TrabalhoFBD.DAO.MensagemGrupoDAO;
import br.ufc.TrabalhoFBD.DAO.MensagemUsuarioDAO;
import br.ufc.TrabalhoFBD.DAO.UsuarioDAO;
import br.ufc.TrabalhoFBD.model.Grupo;
import br.ufc.TrabalhoFBD.model.MensagemGrupo;
import br.ufc.TrabalhoFBD.model.MensagemUsuario;
import br.ufc.TrabalhoFBD.model.Usuario;

@Transactional
@Controller
public class MensagemController {
	
	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="grupoDAO")
	private GrupoDAO gDAO;
	
	@Autowired
	@Qualifier(value="mensagemUDAO")
	private MensagemUsuarioDAO mUDAO;
	
	@Autowired
	@Qualifier(value="mensagemGDAO")
	private MensagemGrupoDAO mGDAO;
	
	@RequestMapping("/listarConversa")
	public String listarConversa(Long idUsuario1, Long idUsuario2, Model model){
		Usuario a = uDAO.recuperarById(idUsuario1);
		List<MensagemUsuario> conversa = mUDAO.getConversa(idUsuario1, idUsuario2);
		model.addAttribute("amigo", a);
		model.addAttribute("conversa", conversa);
		return "home";
		
	}
	
	@RequestMapping("/listarConversaGrupo")
	public String listarConversa(Long idGrupo, Model model){
		Grupo g = gDAO.recuperarById(idGrupo);
		List<MensagemGrupo> conversaGrupo = mGDAO.getMensagensGrupo(g);
		model.addAttribute("grupo", g);
		model.addAttribute("conversaGrupo", conversaGrupo);
		return "home";
		
	}
	
	@RequestMapping("/inserirMensagem")
	public String inserirMensagem(Long remetente, Long destinatario, String corpo,HttpSession session){
		MensagemUsuario mensagem = new MensagemUsuario();
		System.out.println(remetente);
		Usuario r = uDAO.recuperarById(remetente);
		Usuario d = uDAO.recuperarById(destinatario);
		mensagem.setDataHoraEnvio(new Timestamp(System.currentTimeMillis()));
		mensagem.setDestinatario(d);
		mensagem.setRemetente(r);
		mensagem.setCorpo(corpo.replaceFirst(",", ""));
		mUDAO.inserir(mensagem);
		return "redirect:listarConversa?idUsuario1="+destinatario+"&idUsuario2="+remetente;
		
	}
	
	@RequestMapping("/inserirMensagemGrupo")
	public String inserirMensagemGrupo(Long remetente, Long destinatario, String corpo,HttpSession session){
		MensagemGrupo mensagem = new MensagemGrupo();
		System.out.println(remetente);
		Usuario r = uDAO.recuperarById(remetente);
		Grupo d = gDAO.recuperarById(destinatario);
		mensagem.setDataHoraEnvio(new Timestamp(System.currentTimeMillis()));
		mensagem.setDestinatario(d);
		mensagem.setRemetente(r);
		mensagem.setCorpo(corpo.replaceFirst(",", ""));
		mGDAO.inserir(mensagem);
		return "redirect:listarConversaGrupo?idGrupo="+destinatario;
		
	}


}
