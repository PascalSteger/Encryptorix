/**
 * @file AddBlindRandom.java
 * AddBlindRandom is an EncryptionScheme that inserts random chars
 * at random positions into the text
 * > working with Strings <
 */

/**
 * @author Pascal S.P. Steger
 * @email psteger@ethz.ch
 * @date 20100317
 */
public class AddBlindRandom extends EncryptionScheme {

	private double key_;

	public AddBlindRandom() {
		key_ = 0.15;
	}

	public AddBlindRandom(double key) {
		if (key < 0)
			key = -key;
		if (key == 0)
			key = 0.15;
		key_ = key;
	}

	public SignArray encrypt(SignArray text) {
		String strtext=text.toString();
		String tc = "";
		for (int i = 0; i < strtext.length(); ++i) {
			if (Math.random() > key_)
				tc = tc.concat(strtext.substring(i, i + 1));
			else {
				int offset = (new Long(Math.round(Math.floor(26 * Math.random()))))
						.intValue();
				Character alower = Character.toChars('a' + offset)[0];
				Character aupper = Character.toChars('A' + offset)[0];
				String randomString;
				if (Math.random() < 0.5)
					randomString = alower.toString();
				else
					randomString = aupper.toString();
				tc = tc.concat(randomString);
				--i;
			}
		}
		SignArray sa = new SignArray(tc);
		return sa;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test
		AddBlindRandom ab = new AddBlindRandom();
		SignArray asa = new SignArray("Take all the students that fell asleep and lie them in a row...");
		System.out.println(ab.encrypt(asa).toString());

		AddBlindRandom ac = new AddBlindRandom(5);
		SignArray bsa = new SignArray("123456123456123456123456");
		System.out.println(ac.encrypt(bsa).toString());
	}

}
