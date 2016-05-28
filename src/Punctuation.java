/**
 * @file Punctuation.java
 * Punctuation inside a text
 * TODO
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100101
 */
public class Punctuation {
	private int pos_;
	private char ch_;
	
	public Punctuation(){
		ch_ = '.';
		pos_ = 0;
	}
	
	public Punctuation(int pos, char ch){
		pos_ = pos;
		ch_  = ch;
	}
	
	public void setPos(int pos){
		pos_ = pos;
	}
	
	public void setCh(char ch){
		ch_ = ch;
	}
	
	public int getPos(){
		return pos_;
	}
	
	public char getCh(){
		return ch_;
	}
	
	public boolean isPunctuation(char ch){
		switch(ch){
		case('.'):
		case(','):
		case('!'):
		case('?'):
		case(':'):
			return true;
		default:
			return false;
		}
	}
	
	public String toString(){
		String re = "";
		re += ch_;
		return re;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test routine
		Punctuation pt = new Punctuation(10,'.');
		System.out.println(pt.toString());
	}

}
