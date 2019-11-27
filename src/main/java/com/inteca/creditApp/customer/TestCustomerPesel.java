package com.inteca.creditApp.customer;

import junit.framework.TestCase;
import org.hibernate.validator.internal.constraintvalidators.hv.pl.PESELValidator;

public class TestCustomerPesel extends TestCase
{
    public void testCustomerPesel()
    {
        PESELValidator validator = new PESELValidator();
        validator.initialize(null); //wymagana inicajalizacja

        String validPesel = "88051848299";
        assertTrue(validator.isValid(validPesel, null));

        validPesel = "75120215478";
        assertFalse(validator.isValid(validPesel, null));

        validPesel = "123";
        assertFalse(validator.isValid(validPesel, null));

        validPesel = "123456789101";
        assertFalse(validator.isValid(validPesel, null));

        validPesel = "";
        assertFalse(validator.isValid(validPesel, null));

        validPesel = "abc";
        assertFalse(validator.isValid(validPesel, null));

        validPesel = "*/-+=][;'><.;$@";
        assertFalse(validator.isValid(validPesel, null));

        validPesel = "123456789xy";
        assertFalse(validator.isValid(validPesel, null));
    }
}
