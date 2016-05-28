import java.util.Vector;

/**
 * @file Sentence.java
 * holds information on structural components called "sentence"
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100323
 */
public class Sentence {
	private Vector<Punctuation> punct_;
	private Vector<Word> words_;
	
	public Sentence(){
		//nothing to do
		punct_ = new Vector<Punctuation>();
		words_ = new Vector<Word>();
	}
	
	public Sentence(String text){
		punct_ = new Vector<Punctuation>();
		words_ = new Vector<Word>();
		calcWords(text);
	}
	
	public Vector<Punctuation> getPunct(){
		return punct_;
	}
	
	public Vector<Word> getWords(){
		return words_;
	}
	
	private void calcWords(String text){
		int start=0,len=0;
		for(int i=0;i<text.length();++i){
			Punctuation pt = new Punctuation();
			if(Character.isLetterOrDigit(text.charAt(i))){
				++len;
			} else {
				if(pt.isPunctuation(text.charAt(i))){
					pt.setPos(i);
					pt.setCh(text.charAt(i));
					punct_.addElement(pt);
				}
				if(len==0){
					start = i+1;
					continue;
				}
				words_.add(new Word(start,text.substring(start, start+len)));
				start=i+1;
				len=0;
			}
		}
	}
	
	public String toString(){
		String sen = "";
		for(int i=0;i<words_.size();++i){
			sen+=words_.elementAt(i);
			sen+="|";
		}
		sen+='\n';
		for(int i=0;i<punct_.size();++i){
			sen+=punct_.elementAt(i);
			sen+="|";
		}
		return sen;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test
		Sentence ans = new Sentence("Dieser Satz, genau dieser, hat ein paar davon: Satzzeichen.");
		System.out.println(ans.toString());

	}

}
