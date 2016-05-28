/**
 * @file ToUpper.java
 * ToUpper is the contrary of ToLower
 * > tested <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100130
 */
public class ToUpper extends EncryptionScheme {

	public SignArray encrypt(SignArray text){
		String clear=text.toString().toUpperCase();
		SignArray sa = new SignArray(clear);
		return sa;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToUpper test = new ToUpper();
		SignArray asa = new SignArray("My little Brother does NOT like fish.");
		asa = test.encrypt(asa);
		System.out.println(asa.toString());
	}
}
