/**
 * @file Base64.java
 * Base64 encodes a charstream by using Base64 encryption :o)
 * TODO
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100314
 */
public class Base64 extends EncryptionScheme {

	public String encrypt(String clear) {
		/*
		 * import java.io.IOException; import java.util.; import sun.misc.;
		 * 
		 * public class Base64Demo { public static void main( String[] args )
		 * throws IOException { byte[] bytes1 = new byte[ 112 ]; new
		 * Random().nextBytes( bytes1 );
		 * 
		 * // Convert byte array to String 
		 * String s = new
		 * BASE64Encoder().encode( bytes1 ); System.out.println( s );
		 * 
		 * // String s contains for example: 
		 * // * QFgwDyiQ28/4GsF75fqLMj/bAIWNwOuBmE 
		 * * /SCl3H2XQFpSsSz0jtyR0LU+kLiwWsnSUZljJr97Hy 
		 * // * LA3YUbf96Ym2zx9F9Y1N7P5lsOCb/vr2crTQ/gXs757qaJF9E3szMN+E0CSSslDrrzcNBrlcQg==
		 * 
		 * 
		 * // Convert String back to byte[]
		 * byte[] bytes2 = new
		 * BASE64Decoder().decodeBuffer( s ); System.out.println(
		 * Arrays.equals(bytes1, bytes2) ); // true } }
		 */
		return clear;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ToLower test = new ToLower();
		SignArray asa = new SignArray("My little Brother does NOT like fish.");
		System.out.println(test.encrypt(asa).toString());
	}

}
