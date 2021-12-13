package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<Frame> frames;
    private int currentFrameIndex;

    public Game() {
        frames = new ArrayList<>();
        frames.add(new Frame());
    }

    public int bowl(int[] rolls) {
        for (int roll : rolls) {
            if (frames.get(currentFrameIndex).isOver()) {
                frames.add(new Frame());
                currentFrameIndex++;
            }
            Frame currentFrame = frames.get(currentFrameIndex);
            currentFrame.bowl(roll);

            if (currentFrameIndex >= 2)
                if (frames.get(currentFrameIndex - 2).isStrike()
                    && frames.get(currentFrameIndex - 1).isStrike()
                    && currentFrame.getLength() == 1) {
                    frames.get(currentFrameIndex - 2).addBonus(roll);
                }
            if (currentFrameIndex >= 1) {
                if (frames.get(currentFrameIndex - 1).isSpare()
                        && currentFrame.getLength() == 1) {
                    frames.get(currentFrameIndex - 1).addBonus(roll);
                }
                if (frames.get(currentFrameIndex - 1).isStrike()) {
                    frames.get(currentFrameIndex - 1).addBonus(roll);
                }
            }
        }

        int score = 0;
        for (Frame frame : frames) {
            score += frame.getScore();
        }
        return score;
    }

}
