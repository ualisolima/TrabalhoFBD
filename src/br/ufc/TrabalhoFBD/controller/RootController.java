package br.ufc.TrabalhoFBD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
public class RootController {

	@RequestMapping("/root")
	public String root(){
		return "home";
	}
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
}
