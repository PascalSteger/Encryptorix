/**
 * @file Cleartext.java
 * Cleartext holds all methods that can be executed on a human-readable text
 * TODO: Structure, Language
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@phys.ethz.ch
 * @date 20100317
 */
public class Cleartext {
	/**
	 * @param args
	 */
	public static void main( final String[] args ) {
		// test
		final Cleartext ct = new Cleartext();
		ct.setText( "late is not too late" );
		System.out.println( ct.toString() );

		final Cleartext ct2 = new Cleartext( "but earlier is better" );
		System.out.println( ct2.toString() );
	}

	// Structure struct_;
	private String		text_;
	private Structure	struc_;
	// Word[] words_;
	// Punctuation punctuation_;

	private Language	lang_;

	public Cleartext() {
		text_ = "";
	}

	public Cleartext(final String text) {
		text_ = text;
	}

	public String getText() {
		return text_;
	}

	public void setText( final String text ) {
		text_ = text;
	}

	@Override
	public String toString() {
		return text_;
	}

}
