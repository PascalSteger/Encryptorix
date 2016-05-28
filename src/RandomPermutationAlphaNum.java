/**
 * @file RandomPermutationAlphaNum.java
 * RandomPermutationAlphaNum generates a random permutation of an array
 * consisting of ASCII :alnum: chars
 * > tested <
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100315
 */
public class RandomPermutationAlphaNum extends EncryptionScheme {

	private List<Character> key_;
	
	public RandomPermutationAlphaNum(){
		System.out.println("RandomPermutationAlphaNum(): generating random permutation...");
		String key = "abcdefghijklmnopqrstuvwxyz01234567890";
		StringBuffer sb = new StringBuffer(key);
		List<Character> ls = new ArrayList<Character>(36);
		for(int i=0; i<sb.length(); ++i){
			ls.add(sb.charAt(i));
		}
		Collections.shuffle(ls);
		key_ = ls;
		System.out.println(key_);
	}

	public String encrypt(String text){
		String tc = "";
		for(int i=0; i<text.length(); ++i){
			int strpos;
			if (Character.isLetter(text.charAt(i)))
				strpos = text.charAt(i)-'a';
			else
				strpos = text.charAt(i)-'0'+25;
			tc=tc.concat(key_.get(strpos).toString());
		}
		return tc;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test
		String astring = "asampletextwith1234numbersshuffled";
		System.out.println(astring);

		RandomPermutationAlphaNum rpa = new RandomPermutationAlphaNum();
		System.out.println(rpa.encrypt(astring));
	}

}
