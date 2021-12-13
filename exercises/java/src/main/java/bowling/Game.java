package bowling;

public class Game {
    public int bowl(int[] rolls) {
        int score = 0;
        boolean isSpare = false;
        for (int i = 0; i < rolls.length / 2; i++) {
            int frameScore = rolls[2 * i] + rolls[2 * i + 1];
            if (isSpare) {
                score += rolls[2 * i];
                isSpare = false;
            }
            if (frameScore == 10) {
                isSpare = true;
            }
            score += frameScore;
        }
        return score;
    }
}
