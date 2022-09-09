package tk.leooresende01.webformsecurity.infra.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tk.leooresende01.webformsecurity.infra.repository.UsuarioRepository;
import tk.leooresende01.webformsecurity.model.Usuario;

@Service
public class AutenticationUserService implements UserDetailsService {
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Buscando e verificando se o usuario existe no banco de dados
		try {
			Usuario usuario = UsuarioRepository.findById(username);
			return usuario;
		} catch (Exception ex) {
		} 
		return null;
	}

}
