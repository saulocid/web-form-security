package tk.leooresende01.webformsecurity.infra.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import tk.leooresende01.webformsecurity.infra.controller.dto.ExceptionDto;
import tk.leooresende01.webformsecurity.infra.service.AdviceService;

@RestControllerAdvice
public class GenericsAdvice {
	@Autowired
	private AdviceService service;

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ExceptionDto> faltaDoTipoDeMedia(Exception ex) {
		ExceptionDto exceptionDto = this.service.getExceptionDto(ex);
		return ResponseEntity.status(415).body(exceptionDto);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionDto> faltaDosDadosDaRequisicao(Exception ex) {
		ExceptionDto exceptionDto = this.service.getExceptionDto(ex);
		return ResponseEntity.badRequest().body(exceptionDto);
	}
}
