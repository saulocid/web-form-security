package tk.leooresende01.webformsecurity.model;

import org.springframework.security.core.GrantedAuthority;

public class PerfilDoUsuario implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private String usuario;
	private Perfis perfis;

	public PerfilDoUsuario() {
	}

	public PerfilDoUsuario(String usuario, Perfis perfis) {
		this.usuario = usuario;
		this.perfis = perfis;
	}

	@Override
	public String getAuthority() {
		return this.usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Perfis getPerfis() {
		return perfis;
	}

	public void setPerfis(Perfis perfis) {
		this.perfis = perfis;
	}

}
