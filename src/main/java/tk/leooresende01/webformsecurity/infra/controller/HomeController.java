package tk.leooresende01.webformsecurity.infra.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tk.leooresende01.webformsecurity.infra.service.HomeService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private HomeService service;

	@GetMapping
	public String getPaginaFormLogin(HttpServletRequest req, Model modelo) {
		//Gerando chave privada dinamica e salvando ela na sessão do usuario (vai servir apenas para essa sessão)
		this.service.generateAndSavePrivateKeyInSession(modelo, req);
		return "index.html";
	}

	@GetMapping("/sucesso")
	public String paginaDeLogado() {
		return "auth_success.html";
	}
}
