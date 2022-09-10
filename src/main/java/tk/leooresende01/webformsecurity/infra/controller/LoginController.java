package tk.leooresende01.webformsecurity.infra.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.leooresende01.webformsecurity.infra.controller.dto.AutenticacaoForm;
import tk.leooresende01.webformsecurity.infra.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private LoginService service;

	@PostMapping
	public ResponseEntity<?> autenticarUser(HttpServletRequest req, Model modelo,
			@RequestBody AutenticacaoForm.EncryptedAutenticacaoForm payload,
			@RequestHeader(value="aes-crypt") String aesTimeEncrypt) throws IOException {
		//Pegar chave
		String key = this.service.getKey(req);
		
		//Descriptografando o corpo da requisição e pegando o objeto que representa um formulario de autenticação
		AutenticacaoForm authForm = this.service.getAuthFormFromCrypto(req, payload.getPayload(), key);
		
		//Validar parametros do formulario
		this.service.validarFormParams(authForm);
		
		//Verificando se os parametros passado no cabeçalho e no corpo batem
		this.service.verificarTime(authForm, aesTimeEncrypt, key);
		return this.service.autenticarUsuario(authManager, authForm);
	}
}
