import java.util.Hashtable;

/**
 * @file Alphabet.java
 * Alphabet is a basic encryption of a bitstream
 * > function tested <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100317
 */
public class Alphabet {
    private Hashtable<Integer, Character> alphabet_ = 
	new Hashtable<Integer, Character>();

    public Alphabet(){
	setDefault();
    }

    public Alphabet(Hashtable<Integer, Character> alphabet){
	alphabet_.clear();
	alphabet_ = alphabet;
    }
	
    public void setAlphabet(Hashtable<Integer, Character> alphabet) {
	alphabet_.clear();
	alphabet_ = alphabet;
    }

    public void setAlphabet(String alphabet) {
	alphabet_.clear();
	for (int i = 0; i < alphabet.length(); ++i) {
	    alphabet_.put(i, alphabet.charAt(i));
	}
    }

    public void setDefault() {
	setDefaultUnicodeAlphabet();
    }

    public void emptyAlphabet(){
	alphabet_.clear();
    }
	
    public void setDefaultUnicodeAlphabet() {
	for (Integer i = 0; i < 256; ++i) {
	    if (Character.isISOControl(Character.toChars(i)[0]))
		continue;
	    // System.out.println(Character.toChars(i)[0]);
	    alphabet_.put(i, Character.toChars(i)[0]);
	}
    }

    public void set(Integer key, Character value){
	alphabet_.put(key, value);
    }
	
    public Character get(Integer key){
	return alphabet_.get(key);
    }
	
    public void remove(Integer key){
	alphabet_.remove(key);
    }
	
    public void change(Integer key1, Integer key2){
	Character value1 = alphabet_.get(key1);
	Character value2 = alphabet_.get(key2);
	alphabet_.remove(key1);
	alphabet_.remove(key2);
	alphabet_.put(key1, value2);
	alphabet_.put(key2, value1);
    }
	
    public void reduceToAlNum(){
	for(int i=1;i<256;++i){
	    if(!alphabet_.containsKey(i))
		continue;
	    if(Character.isLetterOrDigit(alphabet_.get(i)))
		continue;
	    alphabet_.remove(i);
	}
    }

    public String toString(){
	return alphabet_.toString();
    }
	
    /**
     * Test routine to determine whether we can change some values of alphabet
     * @param args
     */
    public static void main(String[] args) {
	// test
	Alphabet al = new Alphabet();
	//al.change(255,254);
	al.reduceToAlNum();
	System.out.println(al.toString());
    }
}
