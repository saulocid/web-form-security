package tk.leooresende01.webformsecurity.infra.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.lang.NonNull;

public class AutenticacaoForm {
	@NonNull
	@NotBlank
	@Pattern(regexp = "^[A-Za-z]\\w{5,29}$")
	private String username;
	@NonNull
	@NotBlank
	@Pattern(regexp = "^[A-Za-z]\\w{5,29}$")
	private String password;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AutenticacaoForm [username=" + username + ", password=" + password + "]";
	}

	public static class EncryptedAutenticacaoForm {
		private String payload;

		public String getPayload() {
			return payload;
		}

		public void setPayload(String payload) {
			this.payload = payload;
		}

	}

}
