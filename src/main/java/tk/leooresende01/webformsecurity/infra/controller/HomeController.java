package tk.leooresende01.webformsecurity.infra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tk.leooresende01.webformsecurity.infra.controller.dto.AutenticacaoForm;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String getPaginaFormLogin(Model modelo, AutenticacaoForm authForm) {
		modelo.addAttribute("formLogin", authForm);
		return "index.html";
	}
	
	@PostMapping
	public String autenticarUser(AutenticacaoForm authForm, Model modelo) {
		modelo.addAttribute("formLogin", new AutenticacaoForm());
		System.out.println(authForm);
		return "index.html";
	}
}
