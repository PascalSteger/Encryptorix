/**
 * @file Message.java
 * Class for holding cleartext and transformed text
 * > working <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100315
 */
public class Message {

    SignArray cleartext_ = new SignArray();
    SignArray uncleartext_ = new SignArray();

    /*
     * if no specific message text is given as a starting point, leave alone
     */
    public Message(){
	// nothing done
    }
	
    /*
     * for convenience only: convert a text from String to Integer[][]
     */
    public Message(String text) {
	cleartext_.setText(text);
    }
	
    /*
     * constructor using an array of Integers,
     */
    public Message(Integer[][] text){
	cleartext_.setText(text);
    }

    /*
     * for convenience: initiate cleartext with a String
     */
    public void setCleartext(String text) {
	cleartext_.setText(text);
    }

    public void setCleartext(Integer[][] text){
	cleartext_.setText(text);
    }
	
    public void setUncleartext(String text){
	uncleartext_.setText(text);
    }
	
    public void setUncleartext(Integer[][] text){
	uncleartext_.setText(text);
    }
	
    public SignArray getCleartext(){
	return cleartext_;
    }
	
    public SignArray getUncleartext(){
	return uncleartext_;
    }

    public void showCleartext() {
	System.out.println(cleartext_.toString());
    }
	
    public void showUncleartext(){
	System.out.println(uncleartext_.toString());
    }

    public void encrypt(EncryptionChain ec){
	System.out.println("in Message::encrypt");
	uncleartext_.setText(ec.encrypt(cleartext_).toString());
    }
	
    /**
     * Sample usage of Message class with initialization from String and output.
     * @param args
     */
    public static void main(String[] args) {
	String cleartxt = "So lie the dead leaves; but they and such as they nourish forever that great old trunk of England, which still sheds forth another crop and another, each as strong and as fair as the last.  The body may lie in moldering chancel, or in crumbling vault, but the rumor of noble lives, the record of valor and truth, can never die, but lives on in the soul of the people.  Our own work lies ready to our hands; and yet our strength may be the greater and our faith the firmer if we spare an hour from present toils to look back upon the women who were gentle and strong, or the men who loved honor more than life, on this green stage of England where for a few short years we play our little part.";

	Message exampleMessage = new Message();
	exampleMessage.setCleartext(cleartxt);
	exampleMessage.showCleartext();
	System.out.println(exampleMessage.getCleartext().getFrequencyString());
    }

}
