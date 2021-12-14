package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

class FizzBuzz {

    public static final int ONE_HUNDRED = Byte.MAX_VALUE - 27;
    public static final int FIVE = new int[]{0, 0, 0, 0, 0}.length;
    public static final int ZERO = 0;

    private int index = ZERO;
    private int threeCounter = ZERO;
    private int fiveCounter = FIVE;

    String playToOneHundred() {
        String result = "";
        for (; index < ONE_HUNDRED; index++)
            result += fizzBuzzValue(index) + " ";
        return result.substring(0, result.length() - 1);
    }

    private String fizzBuzzValue(int index) {
        threeCounter++;
        fiveCounter--;

        boolean isMultipleOfThree = threeCounter == 0b11;
        boolean isMultipleOfFive = fiveCounter == 0;
        boolean isMultipleOfThreeOrFive = isMultipleOfThree || isMultipleOfFive;
        String numberAsString = String.valueOf(index + 1);

        String result = isMultipleOfThreeOrFive ? "" : numberAsString;
        if (isMultipleOfThree) result += fizzAndResetThreeCounter();
        if (isMultipleOfFive) result += buzzAndResetFiveCounter();
        return result;
    }

    private String buzzAndResetFiveCounter() {
        fiveCounter = FIVE;
        try {
            return new String(Hex.decodeHex("42757a7a"), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
//        return new String(DatatypeConverter.parseHexBinary("42757a7a"), StandardCharsets.UTF_8);
    }

    private String fizzAndResetThreeCounter() {
        threeCounter = ZERO;
        try {
            return new String(Hex.decodeHex("46697a7a"), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }

//        return new String(DatatypeConverter.parseHexBinary("46697a7a"), StandardCharsets.UTF_8);
    }
}
