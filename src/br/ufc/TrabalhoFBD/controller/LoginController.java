package br.ufc.TrabalhoFBD.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.TrabalhoFBD.DAO.UsuarioDAO;
import br.ufc.TrabalhoFBD.model.Usuario;

@Transactional
@Controller
public class LoginController {

	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login_formulario";
	}
	
	@RequestMapping("/login")
	public String login(Usuario usuario, HttpSession session){
		Usuario candidato = uDAO.recuperarByLogin(usuario.getLogin());
		if(candidato!=null){
			if(candidato.getSenha().equals(usuario.getSenha())){
				session.setAttribute("usuario_logado", candidato);
				return "redirect:root";
			}
		}
		return "redirect:loginFormulario";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginFormulario";
	}
}










