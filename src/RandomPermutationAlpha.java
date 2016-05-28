/**
 * @file RandomPermutationAlpha
 * RandomPermutationAlpha generates a random permutation of an :alpha: array,
 * as e.g. used in a monoalphabetic substitution
 * > tested <
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100317
 */
public class RandomPermutationAlpha extends EncryptionScheme {

	private List<Character>	key_;

	public RandomPermutationAlpha() {
		System.out.println( "RandomPermutationAlpha(): generating random permutation..." );
		String key = "abcdefghijklmnopqrstuvwxyz";
		StringBuffer sb = new StringBuffer( key );
		List<Character> ls = new ArrayList<Character>( 26 );
		for ( int i = 0; i < sb.length(); ++i ) {
			ls.add( sb.charAt( i ) );
		}
		Collections.shuffle( ls );
		key_ = ls;
		System.out.println( key_ );
	}

	public RandomPermutationAlpha(String key) {
		System.out.println( "RandomPermutationAlpha(): reading permutation..." );
		StringBuffer sb = new StringBuffer( key );
		List<Character> ls = new ArrayList<Character>( 26 );
		for ( int i = 0; i < sb.length(); ++i ) {
			ls.add( sb.charAt( i ) );
		}
		key_ = ls;
		System.out.println( key_ );
	}

	public String encrypt( String text ) {
		String tc = "";
		for ( int i = 0; i < text.length(); ++i ) {
			int strpos = text.charAt( i ) - 'a';
			if ( strpos >= 0 && strpos <= 'z' - 'a' ) {
				tc = tc.concat( key_.get( strpos ).toString() );
			} else {
				tc = tc.concat( new Character( text.charAt( i ) ).toString() );
			}
		}
		return tc;
	}

	@Override
	public SignArray encrypt( SignArray text ) {
		String clear = text.toString();
		SignArray sa = new SignArray( encrypt( clear ) );
		return sa;
	}

	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		// test
		String astring = "the quick brown fox jumps over the läzy dog.";
		System.out.println( astring );

		// RandomPermutationAlpha rpa = new RandomPermutationAlpha();
		String sh = "vxsuperznfbotjlwmagqydichk";
		RandomPermutationAlpha rps = new RandomPermutationAlpha( sh );
		System.out.println( rps.encrypt( astring ) );

	}

}
