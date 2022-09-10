package tk.leooresende01.webformsecurity.infra.service;

import org.springframework.stereotype.Service;

import tk.leooresende01.webformsecurity.infra.controller.dto.ExceptionDto;

@Service
public class AdviceService {
	
	public ExceptionDto getExceptionDto(Exception ex) {
		String nomeDoErro = this.pegarNomeSeparado(ex.getClass().getSimpleName());
		return new ExceptionDto(nomeDoErro, ex.getMessage());
	}
	
	private String pegarNomeSeparado(String nomeDaClasse) {
		StringBuilder nomeSeparado = new StringBuilder();
		for (int i = 0; i < nomeDaClasse.length(); i++) {
			char caractere = nomeDaClasse.charAt(i);
			if (Character.isUpperCase(caractere)) {
				nomeSeparado.append(" " + caractere);
			} else {
				nomeSeparado.append(caractere);
			}
		}
		String nomeDaClasseCompleto = nomeSeparado.toString().strip();
		return nomeDaClasseCompleto.substring(0, nomeDaClasseCompleto.lastIndexOf(" "));
	}
}
