export class CryptoUtil {

	static transformarEmBase64(auth) {
		let authInJson = JSON.stringify(auth);
		return JSON.stringify(btoa(btoa(btoa(authInJson)
			.split('')
			.reverse()
			.join(''))
			.split('')
			.reverse()
			.join('')));
	};

	static criptografarParaAES(value, key) {
		var AESCrypto = CryptoJS.AES.encrypt(value, key).toString();
		return JSON.stringify({
			payload: AESCrypto
		});
	};
}