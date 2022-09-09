package tk.leooresende01.webformsecurity.infra.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class HomeService {

	public static final String PRIVATE_KEY_NAME = "privateKey";

	public void generateAndSavePrivateKeyInSession(Model modelo, HttpServletRequest req) {
		//Gerando a chave que vai criptografar o formulario e salvando ela na sessão (cookie)
		String rsaKey = RandomStringUtils.randomAlphanumeric(17).toUpperCase();
		modelo.addAttribute(PRIVATE_KEY_NAME, rsaKey);
		req.getSession().setAttribute(PRIVATE_KEY_NAME, rsaKey);
	}
	
}
