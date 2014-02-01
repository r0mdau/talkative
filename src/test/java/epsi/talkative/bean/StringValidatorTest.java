package epsi.talkative.bean;

import org.junit.Assert;
import org.junit.Test;

public class StringValidatorTest {
	@Test
    public void emailInvalid() {
            Assert.assertFalse(StringValidator.validateMail("toto"));
            Assert.assertFalse(StringValidator.validateMail("toto@gmail"));
            Assert.assertFalse(StringValidator.validateMail("toto@gmail.rater."));
    }
	
	@Test
    public void emailValid() {
            Assert.assertTrue(StringValidator.validateMail("toto@gmail.com"));
            Assert.assertTrue(StringValidator.validateMail("romain@orange.com"));
            Assert.assertTrue(StringValidator.validateMail("super@monsite.fr"));
    }
}
