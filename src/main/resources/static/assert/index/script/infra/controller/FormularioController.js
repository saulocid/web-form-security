import { FormularioService } from "../service/FormularioService.js";
export class FormularioController {
	#form;
	#service;
	#time;
	#key;

	constructor() {
		this.#form = document.getElementById("formLogin");
		this.#service = new FormularioService();
		this.#time = new Date().getTime().toString();
		this.#key = this.#service.pegarPrivateKey(this.#form);
	}

	encriptarInputsAoFazerSubmit() {
		let timer = 0;
		this.#form.addEventListener("submit", evento => {
			evento.preventDefault();
			this.#service.limpaMensagemDeErro();
			timer = this.criptografarAntesDeEnviar(timer, 1000);
		});
	}

	criptografarAntesDeEnviar(timer, sec) {
		clearTimeout(timer);
		return setTimeout(timeout => {
			try {
				let crypto = this.#service.criptografarFormulario(this.#form, this.#time, this.#key);
				let timeCrypt = this.#service.criptografarMilisegundos(this.#time, this.#key);
				this.enviarFormularioDeLogin(crypto, timeCrypt);
			} catch (e) {
				console.log(e)
			}
		}, sec);
	}

	async enviarFormularioDeLogin(body, timeCrypt) {
		let reqLogin = await fetch("/login", {
			method: "POST",
			body: body,
			headers: {
				'content-type': 'application/json',
				'aes-crypt': timeCrypt,
			}
		});
		this.#service.verificarStatusHttp(reqLogin);
	}
}