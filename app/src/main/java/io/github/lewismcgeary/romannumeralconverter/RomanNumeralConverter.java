package io.github.lewismcgeary.romannumeralconverter;

/**
 * A class which converts integers to Roman Numerals and Roman Numerals to integers.
 *
 * Accepts numbers from 1 to 3999 inclusive in both directions, and will throw an
 * IllegalArgumentException if input is outside of these limits or is not a valid Roman Numeral.
 */

public class RomanNumeralConverter {

    private static class RomanNumeral {
        private final int value;
        private final String symbol;

        RomanNumeral(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }
    }

    // This array contains valid symbols for Roman Numerals.
    // If adding extra symbols to increase the maximum values that can be represented and converted,
    // then also amend the inValidRange() and usesValidCharacters() methods to allow the extra symbols
    // and range.
    private static final RomanNumeral[] numerals = {
            new RomanNumeral(1000, "M"),
            new RomanNumeral(900, "CM"),
            new RomanNumeral(500, "D"),
            new RomanNumeral(400, "CD"),
            new RomanNumeral(100, "C"),
            new RomanNumeral(90, "XC"),
            new RomanNumeral(50, "L"),
            new RomanNumeral(40, "XL"),
            new RomanNumeral(10, "X"),
            new RomanNumeral(9, "IX"),
            new RomanNumeral(5, "V"),
            new RomanNumeral(4, "IV"),
            new RomanNumeral(1, "I")};


    public static String convertIntToRoman(int inputInt) {
        if (!inValidRange(inputInt)){
            throw new IllegalArgumentException("Input must be between 1 and 3999 inclusive.");
        }
        String result = "";
        int remainingInt = inputInt;

        for (int i = 0; i < numerals.length; i++) {
            int numberOfUnits = remainingInt / numerals[i].value;
            remainingInt %= numerals[i].value;
            for (int j = 0; j < numberOfUnits; j++) {
                result += numerals[i].symbol;
            }
        }
        return result;
    }


    public static int convertRomanToInt(String inputString) {
        String inputNumeral = inputString.toUpperCase();

        if(!usesValidCharacters(inputNumeral)){
            throw new IllegalArgumentException("Input must only use characters M, D, C, X, L, V and I.");
        }

        int result = 0;
        int arrayPosition = 0;
        int inputSubstringStart = 0;
        int inputSubstringEnd = 0;

        while (inputSubstringStart < inputNumeral.length()) {
            String currentSymbol = numerals[arrayPosition].symbol;
            inputSubstringEnd = inputSubstringStart + currentSymbol.length();

            if (inputSubstringEnd <= inputNumeral.length()
                    && inputNumeral.substring(inputSubstringStart, inputSubstringEnd).equals(currentSymbol)) {
                result += numerals[arrayPosition].value;
                inputSubstringStart += currentSymbol.length();
            } else {
                arrayPosition++;
                // If Roman numeral symbols are entered in an invalid order the symbol will not be
                // found in the array and the conversion will throw an exception.
                if(arrayPosition >= numerals.length) {
                    throw new IllegalArgumentException("Invalid Roman numeral.");
                }
            }
        }

        if(!inValidRange(result)){
            throw new IllegalArgumentException("Input must be between I and MMMCMXCIX inclusive.");
        }

        return result;
    }

    private static boolean inValidRange(int i) {
        return (0 < i && i < 4000);
    }

    private static boolean usesValidCharacters(String inputNumeral) {
        return inputNumeral.matches("[MDCXLVI]+");
    }
}
