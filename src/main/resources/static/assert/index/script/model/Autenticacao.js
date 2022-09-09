export class Autenticacao {
	#username;
	#password;
	#time;
	
	constructor(username, password, time) {
		this.#username = username;
		this.#password = password;
		this.#time = time;
	}	
	
	get username() {
		return this.#username;
	}
	
	get password() {
		return this.#password;
	}
	
	get time() {
		return this.#time;
	}
}