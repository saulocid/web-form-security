package tk.leooresende01.webformsecurity.infra.controller.advice.exceptions;

public class UsuarioOuSenhaInvalidosException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UsuarioOuSenhaInvalidosException(String msg) {
		super(msg);
	}
	
	public UsuarioOuSenhaInvalidosException() {}
}
