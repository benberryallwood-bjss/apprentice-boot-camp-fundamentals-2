package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

class FizzBuzz {

    public static final int ONE_HUNDRED = Byte.MAX_VALUE - 27;

    private int index;
    private int threeCounter;
    private int fiveCounter;

    String playToOneHundred() {
        String result = "";
        for (; index < ONE_HUNDRED; index++) {
            incrementCounters();
            result += fizzBuzzValue(index) + " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    private String fizzBuzzValue(int index) {
        String numberAsString = String.valueOf(index + 1);
        String result = (isMultipleOfThree() || isMultipleOfFive()) ? "" : numberAsString;
        if (isMultipleOfThree()) result += fizz();
        if (isMultipleOfFive()) result += buzz();
        return result;
    }

    private boolean isMultipleOfThree() {
        return threeCounter == 0;
    }

    private boolean isMultipleOfFive() {
        return fiveCounter == 0;
    }

    private void incrementCounters() {
        threeCounter = (threeCounter + 1) % 3;
        fiveCounter = (fiveCounter + 1) % 5;
    }

    private String buzz() {
        return hexToString("42757a7a");
    }

    private String fizz() {
        return hexToString("46697a7a");
    }

    private String hexToString(String hexValue) {
        try {
            return new String(Hex.decodeHex(hexValue), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
    }

}
