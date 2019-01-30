package fr.wildcodeschool.emailbuilder;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailBuilderTest {

    // --------------------------------------------------------------------------
    // TEST : EmailBuilder.Builder class
    // --------------------------------------------------------------------------


    // --------------------------------------------------------------------------
    // TEST : getEmail method
    // --------------------------------------------------------------------------

    @Test
    public void emailBuilder_GetEmailSimple_ReturnsTrue() {
        EmailBuilder emailBuilder = new EmailBuilder
                .Builder()
                .setUserName("name")
                .setDomain("email")
                .setTld("com")
                .build();
        assertEquals("name@email.com", emailBuilder.getEmail());
    }

    @Test
    public void emailBuilder_GetEmailWithSubDomain_ReturnsTrue() {
        EmailBuilder emailBuilder = new EmailBuilder
                .Builder()
                .setUserName("name")
                .setDomain("email")
                .setSubDomain("co")
                .setTld("uk")
                .build();
        assertEquals("name@email.co.uk", emailBuilder.getEmail());
    }

    @Test
    public void emailBuilder_GetEmailNoUsername_ReturnsTrue() {
        EmailBuilder emailBuilder = new EmailBuilder
                .Builder()
                .setDomain("email")
                .setSubDomain("co")
                .setTld("uk")
                .build();
        assertEquals("@email.co.uk", emailBuilder.getEmail());
    }

    @Test
    public void emailBuilder_GetEmailNoDomain_ReturnsTrue() {
        EmailBuilder emailBuilder = new EmailBuilder
                .Builder()
                .setUserName("name")
                .setSubDomain("co")
                .setTld("uk")
                .build();
        assertEquals("name@co.uk", emailBuilder.getEmail());
    }

    @Test
    public void emailBuilder_GetEmailNoTld_ReturnsTrue() {
        EmailBuilder emailBuilder = new EmailBuilder
                .Builder()
                .setUserName("name")
                .setDomain("email")
                .setSubDomain("co")
                .build();
        assertEquals("name@email.co", emailBuilder.getEmail());
    }

    @Test
    public void emailBuilder_GetEmailEmptyString_ReturnsTrue() {
        EmailBuilder emailBuilder = new EmailBuilder
                .Builder()
                .setUserName("")
                .setDomain("")
                .setSubDomain("")
                .setTld("")
                .build();
        assertEquals("", emailBuilder.getEmail());
    }

    @Test
    public void emailBuilder_GetNullEmail_ReturnsTrue() {
        EmailBuilder emailBuilder = new EmailBuilder.Builder().build();
        assertEquals("", emailBuilder.getEmail());
    }


    // --------------------------------------------------------------------------
    // TEST : isValidEmail method
    // --------------------------------------------------------------------------

    @Test
    public void emailBuilder_isValidEmailSimple_ReturnsTrue() {
        assertTrue(EmailBuilder.isValidEmail("name@domain.com"));
    }

    @Test
    public void emailBuilder_isValidEmailWithSubDomain_ReturnsTrue() {
        assertTrue(EmailBuilder.isValidEmail("name@domain.subdomain.com"));
    }

    @Test
    public void emailBuilder_isValidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail("@domain.com"));
    }

    @Test
    public void emailBuilder_isValidEmailNoDomain_ReturnsFalse() {

        assertFalse(EmailBuilder.isValidEmail("name@com"));

    }

    @Test
    public void emailBuilder_isValidEmailNoTld_ReturnsFalse() {

        assertFalse(EmailBuilder.isValidEmail("name@domain"));

    }

    @Test
    public void emailBuilder_isValidEmailEmptyString_ReturnsFalse() {

        assertFalse(EmailBuilder.isValidEmail(""));

    }

    @Test
    public void emailBuilder_isValidNullEmail_ReturnsFalse() {

        assertFalse(EmailBuilder.isValidEmail(null));

    }

    @Test
    public void emailBuilder_isValidEmailBadCharacterUsername_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail("*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢@domain.com"));
    }

    @Test
    public void emailBuilder_isValidEmailBadLengthUsername_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +"@domain.com"));
    }

    @Test
    public void emailBuilder_isValidEmailBadCharacterDomain_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail("name@*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢domain.com"));
    }

    @Test
    public void emailBuilder_isValidEmailBadLengthDomain_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail( "name@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaassssssssssaaaaaaaaaaaaaaaaaaaasa.com"));
    }

    @Test
    public void emailBuilder_isValidEmailBadCharacterSubDomain_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail("name@domain.*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢.com"));
    }

    @Test
    public void emailBuilder_isValidEmailBadLengthSubDomain_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail( "name@domain.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaassssssssssaaaaaaaaaaaaaaaaaaaasa.com"));
    }

    @Test
    public void emailBuilder_isValidEmailBadCharacterTld_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail("name@domain.*$£%ù^¨&é\"'()°-è_çà§æ"));
    }

    @Test
    public void emailBuilder_isValidEmailBadLengthTld_ReturnsFalse() {
        assertFalse(EmailBuilder.isValidEmail( "name@domain.aaaaaaaaaaaaaaaaaaaaaaaaas"));
    }

    // Add test here
    // * Check name validity ("*$£%ù^¨&é\"'()°-è_çà§æ«€¶ŧ←↓→øþ¨¤@ßðđŋħłµł»¢@domain.com")
    // * Check name length
    // * Check domain validity
    // * Check domain length
    // * Check sub domain validity
    // * Check sub domain length
    // * Check tld validity
    // * Check tld length
}