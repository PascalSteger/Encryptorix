/**
 * @file StripSyntax.java
 * StripSyntax kills all !:alnum: chars
 * > tested <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100316
 */

public class StripSyntax extends EncryptionScheme {

	public SignArray encrypt(SignArray text){
		String strtext = text.toString();
		StringBuffer tc=new StringBuffer("");
		for(int i=0; i<strtext.length(); ++i){
			if(Character.isLetterOrDigit(strtext.charAt(i)))
				tc.append(strtext.charAt(i));
		}
		SignArray tca = new SignArray(tc.toString());
		return tca;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StripSyntax ss = new StripSyntax();
		SignArray asa=new SignArray("Some text with a little, very little bit of syntax (non-alnum) characters.");
		System.out.println(ss.encrypt(asa).toString());
	}

}
