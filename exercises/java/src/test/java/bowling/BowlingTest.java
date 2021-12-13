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
}
