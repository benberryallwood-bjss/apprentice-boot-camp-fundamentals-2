package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

class FizzBuzz {

    private int index;
    private int threeCounter;
    private int fiveCounter = new int[]{0, 0, 0, 0, 0}.length;

    String playToOneHundred() {
        String result = "";
        for (; index < Byte.MAX_VALUE - 27; index++)
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
        fiveCounter = new int[]{0, 0, 0, 0, 0}.length;
        try {
            return new String(Hex.decodeHex("42757a7a"), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
//        return new String(DatatypeConverter.parseHexBinary("42757a7a"), StandardCharsets.UTF_8);
    }

    private String fizzAndResetThreeCounter() {
        threeCounter = 0;
        try {
            return new String(Hex.decodeHex("46697a7a"), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }

//        return new String(DatatypeConverter.parseHexBinary("46697a7a"), StandardCharsets.UTF_8);
    }
}
