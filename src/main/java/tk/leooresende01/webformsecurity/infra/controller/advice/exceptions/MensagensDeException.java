package tk.leooresende01.webformsecurity.infra.controller.advice.exceptions;

public enum MensagensDeException {
	USUARIO_E_SENHAS_INVALIDOS("Usuario e/ou senha com caracteres invalidos"),
	FALTA_DE_PARAMETROS("Faltam parametros na requisição"),
	PARAMETROS_INVALIDOS("Alguns parametros da requisição são invalidos");
	
	private String mensagem;
	
	MensagensDeException(String string) {
		this.mensagem = string;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
	
	@Override
	public String toString() {
		return this.mensagem;
	}
}
