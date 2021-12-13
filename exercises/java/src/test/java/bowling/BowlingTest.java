package bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.*;

public class BowlingTest {
    @Test
    public void scoreGameOfZeros() {
        Game game = new Game();
        int[] rolls = new int[]{0,0, 0,0, 0,0, 0,0, 0,0,
                                0,0, 0,0, 0,0, 0,0, 0,0};
        int actual = game.bowl(rolls);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void scoreGameWithoutSparesOrStrikes() {
        Game game = new Game();
        int[] rolls = new int[]{1,1, 1,1, 1,1, 1,1, 1,1,
                                1,1, 1,1, 1,1, 1,1, 1,1};
        int actual = game.bowl(rolls);
        assertThat(actual).isEqualTo(20);
    }
}
