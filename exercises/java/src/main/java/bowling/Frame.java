package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private List<Integer> scores;
    private int totalScore;

    public Frame(int score) {
        scores = new ArrayList<>();
        scores.add(score);
        totalScore = score;
    }

    public Frame(int firstScore, int secondScore) {
        scores = new ArrayList<>();
        scores.add(firstScore);
        scores.add(secondScore);
        totalScore = firstScore + secondScore;
    }

    public void roll(int score) {
        scores.add(score);
    }

    public int getScore() {
        return totalScore;
    }

    public boolean isSpare() {
        return scores.size() == 2 && getScore() == 10;
    }

    public boolean isStrike() {
        return scores.size() == 1 && getScore() == 10;
    }
}
