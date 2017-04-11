package lt.kristinute;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SSNValidatorTest {

    private SSNValidator ssnValidator = new SSNValidator();

    @Test
    public void isValidSwedishSsn() throws Exception {
        assertTrue(ssnValidator.isValidSwedishSsn("8611163067"));
        assertFalse(ssnValidator.isValidSwedishSsn("8611163066"));
    }

    @Test
    public void requiresValidLength() throws Exception {
        assertFalse(ssnValidator.isValidSwedishSsn("861116306"));
    }

     @Test
    public void requiresDigits() throws Exception {
        assertFalse(ssnValidator.isValidSwedishSsn("861116306X"));
        assertFalse(ssnValidator.isValidSwedishSsn("X611163067"));
    }

    @Test
    public void allowsDashBeforeFinalFourDigits() throws Exception {
        assertTrue(ssnValidator.isValidSwedishSsn("861116-3067"));
    }

    @Test
    public void doesNotAllowsDashInOtherPlaces() throws Exception {
        assertFalse(ssnValidator.isValidSwedishSsn("86111-63067"));
        assertFalse(ssnValidator.isValidSwedishSsn("8611163-067"));
        assertFalse(ssnValidator.isValidSwedishSsn("-8611163067"));
    }

}