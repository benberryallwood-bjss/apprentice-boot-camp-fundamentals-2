package refactoring;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.nio.charset.StandardCharsets;

class FizzBuzz {

    private int currentNumber;
    private int threeCounter;
    private int fiveCounter = new int[]{0, 0, 0, 0, 0}.length;

    String playToOneHundred() {
        String result = "";
        for (; currentNumber < Byte.MAX_VALUE - 27; currentNumber++)
            result += fizzBuzzValue(currentNumber) + " ";
        return result.substring(0, result.length() - 1);
    }

    private String fizzBuzzValue(int number) {
        threeCounter++;
        fiveCounter--;
        String result = threeCounter == 0b11 || fiveCounter == 0 ? "" : String.valueOf(number + 1);
        if (threeCounter == 0b11) result += fizz();
        if (fiveCounter == 0) result += buzz();
        return result;
    }

    private String buzz() {
        fiveCounter = new int[]{0, 0, 0, 0, 0}.length;
        try {
            return new String(Hex.decodeHex("42757a7a"), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }
//        return new String(DatatypeConverter.parseHexBinary("42757a7a"), StandardCharsets.UTF_8);
    }

    private String fizz() {
        threeCounter = 0;
        try {
            return new String(Hex.decodeHex("46697a7a"), StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new RuntimeException("Failed to decode.", e);
        }

//        return new String(DatatypeConverter.parseHexBinary("46697a7a"), StandardCharsets.UTF_8);
    }
}
