/**
 * @file ToLower.java
 * ToLower is an "EncryptionScheme" that shifts A..Z => a..z
 * > tested <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100130
 */
public class ToLower extends EncryptionScheme {

	public SignArray encrypt(SignArray text){
		String clear = text.toString().toLowerCase();
		SignArray sa = new SignArray(clear);
		return sa;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToLower test = new ToLower();
		SignArray asa = new SignArray("My little Brother does NOT like fish.");
		System.out.println(test.encrypt(asa).toString());
	}

}
