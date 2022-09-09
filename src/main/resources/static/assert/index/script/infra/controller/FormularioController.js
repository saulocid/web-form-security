import {FormularioService} from "../service/FormularioService.js";
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
		this.#form.addEventListener("submit", evento => {
			evento.preventDefault();
			try {		
				let crypto = this.#service.criptografarFormulario(this.#form, this.#time, this.#key);
				this.enviarFormularioDeLogin(crypto);
			} catch(e){console.log(e)}
		});
	}
	
	async enviarFormularioDeLogin(body) {
		let timeCrypt = this.#service.criptografarMilisegundos(this.#time, this.#key);
		let formLogin = await fetch("/login", {
			method: "POST",
			body: body,
			headers: {
				'Content-Type': 'application/json',
				'Aes-Crypt': timeCrypt
			}
		});
		let statusHttp = formLogin.status;
		this.#service.verificarStatusHttp(statusHttp);
	}
}