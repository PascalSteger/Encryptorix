import java.util.Vector;

/**
 * @file EncryptionChain
 * EncryptionChain concatenates different EncryptionSchemes and
 * runs them in order on a Cleartext
 * > tested <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100317
 */
public class EncryptionChain {
    //holds a chain of EncryptionSchemes
    private Vector<EncryptionScheme> enc_scheme_ = new Vector<EncryptionScheme>();
    private int size_ = 0;
	
    public EncryptionChain(){
	System.out.println("In constructor EncryptionChain()");
    }
	
    public void add(EncryptionScheme enc_scheme){
	enc_scheme_.addElement(enc_scheme);
	++size_;
    }
	
    public int length(){
	return size_;
    }
	
    public SignArray encrypt(SignArray text){
	for(int i=0; i<size_; ++i){
	    text = enc_scheme_.elementAt(i).encrypt(text);
	}
	return text;
    }
	
    public SignArray decrypt(SignArray text){
	for(int i=size_-1;i>=0;--i){
	    text = enc_scheme_.elementAt(i).decrypt(text);
	}
	return text;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
	// test
	EncryptionChain ec = new EncryptionChain();
	ec.add(new StripSyntax());
	ec.add(new ToLower());
	ec.add(new Cesar());
	System.out.println("Size of chain: "+ec.length());
	SignArray asa = new SignArray("This Text is about to be eNcrypted one time.");
	System.out.println(asa.toString());
	System.out.println(ec.encrypt(asa).toString());
    }

}
