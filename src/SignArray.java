/**
 * @file SignArray.java
 * SignArray is used when decrypting a message
 * It holds all information encoded as integers
 * further generalization is planned with BitStream
 * > tested <
 */
import java.util.*;

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100317
 */
public class SignArray {

	private Integer[][] text_;
	private Vector<Integer> textlist_ = new Vector<Integer>();
	private Alphabet alphabet_;

	public SignArray() {
		System.out.println("No text specified => give me something to work on.");
		alphabet_ = new Alphabet();
	}

	public SignArray(Integer[][] text) {
		text_ = text;
		generateTextlist();
		alphabet_ = new Alphabet();
	}

	public SignArray(Vector<Integer> textlist) {
		textlist_ = textlist;
		text_ = (Integer[][]) textlist.toArray();
		alphabet_ = new Alphabet();
	}

	public SignArray(String text) {
		alphabet_ = new Alphabet();
		setText(text);
	}

	private void generateTextlist() {
		for (int i = 0; i < text_.length; ++i)
			for (int j = 0; j < text_[i].length; ++j)
				textlist_.add(text_[i][j]);
	}

	public void setText(Integer[][] text) {
		text_ = text;
		generateTextlist();
		//alphabet_.setDefault();
	}

	public void setText(String text) {
		Vector<Integer> textlist = new Vector<Integer>();
		for (int i = 0; i < text.length(); ++i) {
			int anint = text.charAt(i);
			textlist.add(anint);
		}
		textlist_ = textlist;
		Integer[] ntx = new Integer[textlist_.size()];
		for (int i = 0; i < textlist_.size(); ++i) {
			ntx[i] = textlist_.elementAt(i);
		}
		Integer[][] ntxl = { ntx };
		text_ = ntxl;
	}

	public Vector<Hashtable<Vector<Integer>, Double>> getFrequency() {
		Vector<Hashtable<Vector<Integer>, Double>> frequency = new Vector<Hashtable<Vector<Integer>, Double>>();
		System.out.println("In searchFrequency");
		// if we need full text frequencies
		// for(int subtextLength = 1; subtextLength <= textlist_.size(); ++
		// subtextLength){
		for (int subtextLength = 1; subtextLength < 10; ++subtextLength) {
			frequency.add(new Hashtable<Vector<Integer>, Double>());
			// System.out.println("Generating list for substrings of length "+
			// subtextLength);
			for (int i = 0; i <= textlist_.size() - subtextLength; ++i) {
				int count = 0;
				List<Integer> cti = textlist_.subList(i, i + subtextLength);
				if (frequency.elementAt(subtextLength - 1).containsKey(cti)) {
					// System.out.println("Substring already known.");
					continue;
				}
				// System.out.println("New substring: "+cti.toString());
				for (int j = 0; j <= textlist_.size() - subtextLength; ++j) {
					List<Integer> ctj = textlist_.subList(j, j + subtextLength);
					if (cti.equals(ctj)) {
						++count;
					}
				}
				// cast for Hashtable
				Vector<Integer> ct = new Vector<Integer>();
				for (int k = 0; k < cti.size(); ++k) {
					ct.add(cti.get(k));
				}
				// if we want all values as fractions
				// frequency_.elementAt(subtextLength-1).put(ct,
				// (count*1.0)/(textlist_.size()-subtextLength+1));
				// if we want all values as number counts
				frequency.elementAt(subtextLength - 1).put(ct, (count * 1.0)/(textlist_.size()-subtextLength+1));
				// if we are only interested in recurrences
				// if(count>1)
				// frequency_.elementAt(subtextLength-1).put(ct, 1.0*count);
			}
		}
		return frequency;
	}

	public String getTextlistString() {
		return textlist_.toString();
	}

	public String getAlphabetString() {
		return alphabet_.toString();
	}

	public String getFrequencyString() {
		Vector<Hashtable<Vector<Integer>, Double>> frequency = getFrequency();
		String con = new String("");
		for (int i = 0; i < frequency.size(); ++i) {
			con = con.concat(frequency.elementAt(i).values().toString());
			con = con.concat("\n");
		}
		return con;
	}

	public String toString() {
		String con = new String("");
		for(int i=0; i<textlist_.size();++i){
			con = con + alphabet_.get(textlist_.get(i));
		}
		return con;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test
		Integer[][] te = { { 97, 103, 103, 102 }, { 104, 103, 103, 102, 105 } };
		SignArray uc = new SignArray(te);
		System.out.println(uc.toString());
		System.out.println(uc.getAlphabetString());
		System.out.println(uc.getFrequencyString());
		
		SignArray asa = new SignArray("My bonnie.");
		System.out.println(asa.toString());
	}

}
