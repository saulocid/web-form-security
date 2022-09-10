package tk.leooresende01.webformsecurity.infra.controller.dto;

public class ExceptionDto {
	private String motivo;
	private String mensagem;

	public ExceptionDto() {
	}

	public ExceptionDto(String motivo, String mensagem) {
		this.motivo = motivo;
		this.mensagem = mensagem;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
