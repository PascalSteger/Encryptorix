/**
 * @file EncryptionScheme.java
 * EncryptionScheme is the superclass holding information for 
 * each possible encryption
 * > working, but not useful with encrypt and decrypt
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100112
 */
public class EncryptionScheme {
	//has a key
	
	//and a prescription to encrypt
	public SignArray encrypt(SignArray text){
		return text;
	}
	
	//and a prescription to decrypt
	public SignArray decrypt(SignArray text){
		return text;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test
		EncryptionScheme encs = new Cesar();
		System.out.println(encs.getClass());
	}

}
