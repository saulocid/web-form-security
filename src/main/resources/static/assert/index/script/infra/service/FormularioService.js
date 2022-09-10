import {Autenticacao} from "/assert/index/script/model/Autenticacao.js";
import {CryptoUtil} from "../util/CryptoUtil.js";

export class FormularioService {
	
	
	criptografarFormulario(formulario, time, key) {
		let authDto = this.#pegarAutenticacao(formulario, time);
		let base64Crypt = CryptoUtil.transformarEmBase64(authDto);
		return CryptoUtil.criptografarParaAES(base64Crypt, key);
	}
	
	criptografarMilisegundos(time, key) {
		return JSON.parse(CryptoUtil.criptografarParaAES(time, key)).payload;
	}
	
	async verificarStatusHttp(reqHttp) {
		if (reqHttp.status == 200) {
			window.location.href = "/sucesso";
		} else {
			let listaDeInputs = document.querySelectorAll(".input-formulario-login");
			listaDeInputs.forEach(input => input.classList.add("input-formulario-login--error"));
			let errorMsg = document.querySelector(".error-message");
			try {				
				let respObject = JSON.parse(await reqHttp.text());
				errorMsg.textContent = respObject.mensagem;
			} catch (e){}
			errorMsg.style.display = "block";
		}
	}
	
	limpaMensagemDeErro() {
		document.querySelector(".error-message").style.display = "none";
	}
	
	#pegarAutenticacao(formulario, time) {
		let usuario = this.#pegarValorAtravezDoName(formulario, "username");
		let senha = this.#pegarValorAtravezDoName(formulario, "password");
		let auth = new Autenticacao(usuario, senha, time);
		return {
			username: auth.username,
			password: auth.password,
			time: auth.time
		};
	}
	
	#pegarValorAtravezDoName(formulario, username) {
		return formulario[username].value;
	}
	
	pegarPrivateKey(formulario) {
		return formulario.dataset.key;
	}
}