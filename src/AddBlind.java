/**
 * @file AddBlind.java
 * AddBlind is an EncryptionScheme that adds single chars 
 * each n characters into the given text
 * > working with Strings <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100318
 */

public class AddBlind extends EncryptionScheme {

	private int key_;

	public AddBlind() {
		key_ = 7;
	}

	public AddBlind(int key) {
		if (key < 0)
			key = -key;
		if (key == 0)
			key = 7;
		key_ = key;
	}

	public String encrypt(String text) {
		String tc = "";
		for (int i = 0; i < text.length() / key_; ++i) {
			tc = tc.concat(text.substring(i * key_, (i + 1) * key_));
			int offset = (new Long(Math.round(26 * Math.random()))).intValue();
			Character alower = Character.toChars('a' + offset)[0];
			Character aupper = Character.toChars('A' + offset)[0];
			String randomString;
			if (Math.random() < 0.5)
				randomString = alower.toString();
			else
				randomString = aupper.toString();
			tc = tc.concat(randomString);
		}
		tc = tc.concat(text.substring((text.length() / key_) * key_));
		return tc;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test
		AddBlind ab = new AddBlind();
		String astring = "Take all the students that fell asleep and lie them in a row...";
		System.out.println(ab.encrypt(astring));

		AddBlind ac = new AddBlind(6);
		String bstring = "123456123456123456123456";
		System.out.println(ac.encrypt(bstring));
	}

}
