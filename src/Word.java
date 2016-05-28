/**
 * @file Word.java
 * Word holds chars bound together to give sense
 * TODO
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100310
 */
public class Word {
	//TODO: encode verbs, nouns, names, adjectives, adverbs, ...
	//TODO: split into main part and rest
	
	private int pos_;
	private String text_;
	
	public Word(){
		//nothing to do
	}
	
	public Word(String text){
		text_ = text;
		pos_ = 0;
	}
	
	public Word(int pos, String text){
		pos_ = pos;
		text_ = text;
	}
	
	public String getText(){
		return text_;
	}
	
	public int getPos(){
		return pos_;
	}
	
	public int length(){
		return text_.length();
	}
	
	public void setText(String text){
		text_ = text;
	}
	
	public void setPos(int pos){
		pos_ = pos;
	}
	
	public String toString(){
		return text_;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
