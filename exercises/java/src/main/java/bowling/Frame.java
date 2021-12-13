package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private List<Integer> scores;
    private int totalScore;

    public Frame() {
        scores = new ArrayList<>();
    }

    public void bowl(int score) {
        scores.add(score);
        totalScore += score;
    }

    public void addBonus(int score) {
        totalScore += score;
    }

    public int getScore() {
        return totalScore;
    }

    public boolean isOver() {
        return scores.size() == 2 || getScore() >= 10;
    }

    public boolean isSpare() {
        return scores.size() == 2 && scores.get(0) + scores.get(1) == 10;
    }

    public boolean isStrike() {
        return scores.size() == 1 && scores.get(0) == 10;
    }

    public int getLength() {
        return scores.size();
    }
}
