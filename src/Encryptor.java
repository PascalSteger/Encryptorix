/**
 * @file Encryptor.java
 * sample program to encode a message
 * of great use for little boyz trying to deceive evedroppers ;o)
 * > tested <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100123 This class uses the different EncryptinSchemes in a chain in
 *       order to encrypt a given text. We can use the output of the main method
 *       for testing the decryptor.
 */
public class Encryptor {

    /**
     * @param args
     */
    public static void main( String[] args ) {
	// take a sample sentence and run a chain of encryptions over it
	// Message msg = new Message( "The ä quick, brown :) fox " +
	// "jumps over the lazy dog." );

	Message msg = new Message( "The quick brown fox jumps over the läzy dog" );
	EncryptionChain firstChain = new EncryptionChain();
	// firstChain.add(new StripSyntax());
	// firstChain.add(new AddBlindRandom());
	firstChain.add( new ToLower() );
	firstChain.add( new Cesar() );
	// firstChain.add( new RandomPermutationAlpha(
	// "superznfwmagqydichvxkotblj" ) );
	firstChain.add( new ToUpper() );
	// firstChain.add( new SplitText() );
	msg.encrypt( firstChain );
	msg.showCleartext();
	msg.showUncleartext();
    }
}
