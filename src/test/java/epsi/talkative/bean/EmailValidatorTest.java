package epsi.talkative.bean;

import org.junit.Assert;
import org.junit.Test;

public class EmailValidatorTest {
	@Test
    public void emailInvalid() {
            Assert.assertFalse(EmailValidator.validateMail("toto"));
            Assert.assertFalse(EmailValidator.validateMail("toto@gmail"));
            Assert.assertFalse(EmailValidator.validateMail("toto@gmail.rater."));
    }
	
	@Test
    public void emailValid() {
            Assert.assertTrue(EmailValidator.validateMail("toto@gmail.com"));
            Assert.assertTrue(EmailValidator.validateMail("romain@orange.com"));
            Assert.assertTrue(EmailValidator.validateMail("super@monsite.fr"));
    }
}
