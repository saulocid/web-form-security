package tk.leooresende01.webformsecurity.infra.controller.advice.exceptions;

public class ParametrosNaRequisicaoInvalidosException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ParametrosNaRequisicaoInvalidosException(String msg) {
		super(msg);
	}
	
	public ParametrosNaRequisicaoInvalidosException() {}
	
}
