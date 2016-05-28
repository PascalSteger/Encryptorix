/**
 * @file SplitText.java
 * SplitText enters spaces with a given frequency into a string
 * > tested <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100314
 */
public class SplitText extends EncryptionScheme {

	private int key_;
	
	public SplitText(){
		key_=5;
	}
	
	public SplitText(int key){
		if(key==0)
			key=5;
		if(key<0)
			key=-key;
		key_=key;
	}
	
	public SignArray encrypt(SignArray text){
		String strtext = text.toString();
		String tc = "";
		for(int i=0;i<strtext.length()/key_;++i){
			tc=tc.concat(strtext.substring(i*key_, (i+1)*key_));
			tc=tc.concat(" ");
		}
		tc=tc.concat(strtext.substring((strtext.length()/key_)*key_));
		SignArray sa = new SignArray(tc);
		return sa;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test
		SplitText st = new SplitText(7);
		SignArray asa = new SignArray("IfIcouldonlyfindmoreexpressivesampletexts...");
		
		System.out.println(st.encrypt(asa));
	}

}
