package tk.leooresende01.webformsecurity.infra.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tk.leooresende01.webformsecurity.infra.controller.advice.exceptions.ParametrosNaRequisicaoInvalidosException;
import tk.leooresende01.webformsecurity.infra.controller.advice.exceptions.MensagensDeException;
import tk.leooresende01.webformsecurity.infra.controller.advice.exceptions.UsuarioOuSenhaInvalidosException;
import tk.leooresende01.webformsecurity.infra.controller.dto.ExceptionDto;
import tk.leooresende01.webformsecurity.infra.service.AdviceService;

@RestControllerAdvice
public class LoginAdvice {

	@Autowired
	private AdviceService service;

	@ExceptionHandler(UsuarioOuSenhaInvalidosException.class)
	public ResponseEntity<ExceptionDto> usuarioOuSenhasInvalidos(Exception ex) {
		ExceptionDto exceptionDto = this.service.getExceptionDto(ex);
		return ResponseEntity.badRequest().body(exceptionDto);
	}

	@ExceptionHandler(ParametrosNaRequisicaoInvalidosException.class)
	public ResponseEntity<ExceptionDto> faltaDeParametros(Exception ex) {
		ExceptionDto exceptionDto = this.service.getExceptionDto(ex);
		return ResponseEntity.badRequest().body(exceptionDto);
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<ExceptionDto> faltaDeParametrosNoCabecalho(Exception ex) {
		ExceptionDto exceptionDto = this.service.getExceptionDto(ex);
		String mensagem = MensagensDeException.FALTA_DE_PARAMETROS.getMensagem();
		exceptionDto.setMensagem(mensagem);
		return ResponseEntity.badRequest().body(exceptionDto);
	}
}
