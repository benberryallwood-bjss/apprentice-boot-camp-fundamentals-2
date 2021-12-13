package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames;

    public Game() {
        frames = new ArrayList<>();
    }

    public int bowl(int[] rolls) {
        int score = 0;
        boolean wasSpare = false;
        boolean wasStrike = false;
        for (int i = 0; i < rolls.length; i += 2) {
            if (wasSpare) {
                score += rolls[i];
                wasSpare = false;
            }
            if (wasStrike) {
                score += rolls[i] + rolls[i + 1];
                wasStrike = false;
            }

            int frameScore;
            if (rolls[i] == 10) {
                frameScore = 10;
                wasStrike = true;
                i--;
            } else {
                frameScore = rolls[i] + rolls[i + 1];
                if (frameScore == 10) {
                    wasSpare = true;
                }
            }
            score += frameScore;
        }
        return score;
    }

}
