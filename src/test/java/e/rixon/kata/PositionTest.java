package e.rixon.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    void a_position_can_be_updated() {
        Position position = new Position(1, 1);
        Position updatedPosition = position.move(1, 0);
        assertEquals(new Position(2, 1), updatedPosition);
    }

    @Test
    void a_position_should_wraparound_if_trying_to_move_beyond_the_edge() {
        Position position = new Position(1, 1);
        Position updatedPosition = position.move(1, 0);
        assertEquals(new Position(2, 1), updatedPosition);
    }
}
