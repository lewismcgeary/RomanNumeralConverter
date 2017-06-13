package io.github.lewismcgeary.romannumeralconverter;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

/**
 */
@RunWith(Parameterized.class)
public class RomanToIntTest {

    @Parameters(name = "{0} returns {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"I", 1},
                {"II", 2},
                {"III", 3},
                {"IV", 4},
                {"V", 5},
                {"VI", 6},
                {"IX", 9},
                {"X", 10},
                {"XII", 12},
                {"XIV", 14},
                {"XVIII", 18},
                {"XIX", 19},
                {"XXIX", 29},
                {"XL", 40},
                {"L", 50},
                {"LXXIV", 74},
                {"XC", 90},
                {"XCIX", 99},
                {"C", 100},
                {"CXXIV", 124},
                {"CCCXXXVIII", 338},
                {"CD", 400},
                {"D", 500},
                {"DCCC", 800},
                {"CM", 900},
                {"M", 1000},
                {"MMMCMXCIX", 3999}
        });
    }

    private String input;
    private int expected;

    public RomanToIntTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void convertRomanToInt() throws Exception {
        int result = RomanNumeralConverter.convertRomanToInt(input);
        Assert.assertEquals(expected, result);
    }
}