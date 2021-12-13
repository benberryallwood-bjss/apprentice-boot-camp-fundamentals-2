package bowling;

public class Game {
    public int bowl(int[] rolls) {
        int score = 0;
        for (int roll : rolls) {
            score += roll;
        }
        return score;
    }
}
