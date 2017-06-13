package io.github.lewismcgeary.romannumeralconverter;

import org.junit.Test;

/**
 */
public class InvalidInputTest {
    @Test(expected = IllegalArgumentException.class)
    public void zThrowsException() throws Exception {
        RomanNumeralConverter.convertRomanToInt("Z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void mmcbThrowsException() throws Exception {
        RomanNumeralConverter.convertRomanToInt("MMCB");
    }

    @Test(expected = IllegalArgumentException.class)
    public void blankThrowsException() throws Exception {
        RomanNumeralConverter.convertRomanToInt(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidStructureThrowsException() throws Exception {
        RomanNumeralConverter.convertRomanToInt("XMLCDM");

    }


    @Test(expected = IllegalArgumentException.class)
    public void zeroInputThrowsException() throws Exception {
        RomanNumeralConverter.convertIntToRoman(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fourThousandInputThrowsException() throws Exception {
        RomanNumeralConverter.convertIntToRoman(4000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeInputThrowsException() throws Exception {
        RomanNumeralConverter.convertIntToRoman(-23);
    }


    @Test(expected = IllegalArgumentException.class)
    public void mmmmThrowsException() throws Exception {
        RomanNumeralConverter.convertRomanToInt("MMMM");
    }
}