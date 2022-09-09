package tk.leooresende01.webformsecurity.infra.controller.dto;

public class AutenticacaoForm {
	private String username;
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
