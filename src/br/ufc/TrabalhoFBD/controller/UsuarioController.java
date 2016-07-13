package br.ufc.TrabalhoFBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.TrabalhoFBD.DAO.EnderecoDAO;
import br.ufc.TrabalhoFBD.DAO.UsuarioDAO;
import br.ufc.TrabalhoFBD.model.Endereco;
import br.ufc.TrabalhoFBD.model.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	@Qualifier(value="usuarioDAO")
	private UsuarioDAO uDAO;
	
	@Autowired
	@Qualifier(value="enderecoDAO")
	private EnderecoDAO eDAO;
	
	
	@RequestMapping("/inserirUsuarioFormulario")
	public String inserirUsuarioFormulario(){
		return "inserir_usuario_formulario";
	}
	
	@RequestMapping("/inserirUsuario")
	public String inserirUsuario(@ModelAttribute("usuario") Usuario usuario, Endereco endereco){
		System.out.println(endereco.getCep() + " : " + usuario.getpNome());
		return "redirect:/";
	}
	
}
