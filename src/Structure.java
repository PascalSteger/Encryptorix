import java.util.Vector;

/**
 * @file Structure.java
 * Structure holds meta-information on text
 * TODO
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100101
 */
public class Structure {
	private Vector<Sentence> sents_;

	public Structure(){
		//nothing to do
	}
	
	public Structure(Vector<Sentence> sents){
		sents_ = sents;
	}
	
	public Structure(String text){
		calcSentences(text);
	}
	/**
	 * split text according to punctuation .!?:
	 * attention for ""!
	 * @param text
	 */
	private void calcSentences(String text){
		int start = 0;
		for(int i=0; i<text.length(); ++i){
			if(text.charAt(i)=='.' || text.charAt(i)=='!' ||
					text.charAt(i)=='?' || text.charAt(i)==':'){
				sents_.add(new Sentence(text.substring(start, i)));
				start = i;
			}
		}
		// if no puncutation sign occured, and for all the rest of text:
		sents_.add(new Sentence(text.substring(start,text.length())));
	}

	public Vector<Sentence> getSentences(){
		return sents_;
	}
	
	public Vector<Word> getWords(){
		Vector<Word> words = new Vector<Word>();
		for(int i=0; i<sents_.size(); ++i){
			for(int j=0; j<sents_.elementAt(i).getWords().size(); ++j){
				words.add(sents_.elementAt(i).getWords().elementAt(j));
			}
		}
		return words;
	}
	
	public String toString(){
		String str = "";
		for(int i=0; i<sents_.size(); ++i){
			System.out.println(sents_.elementAt(i).toString());
		}
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
