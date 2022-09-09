package tk.leooresende01.webformsecurity.infra.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tk.leooresende01.webformsecurity.model.PerfilDoUsuario;
import tk.leooresende01.webformsecurity.model.Perfis;
import tk.leooresende01.webformsecurity.model.Usuario;

public class UsuarioRepository {
	
	private static PasswordEncoder passEncoder = new BCryptPasswordEncoder();
	
	private static final String CREDENCIAIS = "security";
	public static Usuario findById(String id) {
		//Simulando busca de usuarios no DB com Spring Data (Pra não precisar usar configs especificas)
		if (id.equals(CREDENCIAIS)) {			
			return new Usuario(CREDENCIAIS, 
				passEncoder.encode(CREDENCIAIS), 
				new ArrayList<PerfilDoUsuario>(List.of(new PerfilDoUsuario(CREDENCIAIS, Perfis.ROLE_USUARIO))));
		} throw new RuntimeException("Usuario não encontrado");
	}
}
