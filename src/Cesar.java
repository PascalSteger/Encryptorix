/**
 * @file Cesar.java
 * Cesar
 * is EncryptionScheme
 * has Key: shift
 * has Procedure: take char from ClearText
 *     	       move it by shift, mod 26
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100323
 */
public class Cesar extends EncryptionScheme {
	private int key_;
	
	public Cesar(){
		key_=25;
		System.out.println("Cesar without shift mentioned, using -1");
	}
	
	public Cesar(int shift){
		if(shift<0)
			key_ = shift+(-shift/26+1)*26;
		else
			key_ = shift%26;
		System.out.println("Cesar with shift "+key_);
	}
	
	public SignArray encrypt(SignArray sa){
		String ct=sa.toString();
		for(int i=0; i<26; ++i)
			ct=ct.replace(Character.toChars('a'+i)[0],Character.toChars('A'+(i+key_)%26)[0]);
		ct=ct.toLowerCase();
		return new SignArray(ct);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test
		Cesar c = new Cesar();
		SignArray asa = new SignArray("thequickbrownfoxdoesnotjumpoverthelazydog");
		System.out.println(asa.toString());
		asa = c.encrypt(asa);
		System.out.println(asa.toString());
	}

}
