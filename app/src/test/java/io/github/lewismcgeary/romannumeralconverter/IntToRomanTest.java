package io.github.lewismcgeary.romannumeralconverter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

/**
 */
@RunWith(Parameterized.class)
public class IntToRomanTest {

    @Parameters(name = "{0} returns {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, "I" },
                { 2, "II"},
                { 4, "IV"},
                { 5, "V" },
                { 7, "VII"},
                { 9, "IX"},
                { 10, "X"},
                { 19, "XIX"},
                { 20, "XX"},
                { 49, "XLIX"},
                { 57, "LVII"},
                { 175, "CLXXV"},
                { 900, "CM"},
                { 2567, "MMDLXVII"}
        });
    }

    private int input;
    private String expected;

    public IntToRomanTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void convertIntToRoman() throws Exception {
        String result = RomanNumeralConverter.convertIntToRoman(input);
        Assert.assertTrue(result, result.equals(expected));
    }

}