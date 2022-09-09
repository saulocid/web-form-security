package tk.leooresende01.webformsecurity.infra.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tk.leooresende01.webformsecurity.infra.repository.UsuarioRepository;

@Service
public class AutenticationUserService implements UserDetailsService {
	
	//Injetando repositorio de usuarios
	@Autowired
	private UsuarioRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Buscando e verificando se o usuario existe no banco de dados
		return this.userRepo.findById(username).get();
	}

}
