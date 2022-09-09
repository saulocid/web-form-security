package tk.leooresende01.webformsecurity.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private List<PerfilDoUsuario> perfil = new ArrayList<>();

	public Usuario() {
	}

	public Usuario(String username, String password, List<PerfilDoUsuario> perfil) {
		this.username = username;
		this.password = password;
		this.perfil = perfil;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfil;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public List<PerfilDoUsuario> getPerfil() {
		return perfil;
	}

	public void setPerfil(List<PerfilDoUsuario> perfil) {
		this.perfil = perfil;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
