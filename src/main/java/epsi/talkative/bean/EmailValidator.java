package epsi.talkative.bean;

import java.util.regex.Pattern;

public class EmailValidator {
	private static final String EMAIL_PATTERN = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$";

	public static boolean validateMail(final String hex) {
		return Pattern.matches(EMAIL_PATTERN, hex);
	}
}
