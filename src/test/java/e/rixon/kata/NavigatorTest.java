package e.rixon.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static e.rixon.kata.DirectionUtility.getDirection;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigatorTest {

    private Navigator navigator;

    @BeforeEach
    void setUp() {
        navigator = new Navigator(10,10);
    }

    @ParameterizedTest
    @CsvSource({
            "N,W",
            "W,S",
            "S,E",
            "E,N"
    })
    void given_a_direction_when_left_returns_left_direction(String inputDirection, String outputDirection) {
        Direction expected = getDirection(outputDirection);
        Direction current = getDirection(inputDirection);
        assertEquals(expected, navigator.getLeft(current));
    }

    @ParameterizedTest
    @CsvSource({
            "N,E",
            "W,N",
            "S,W",
            "E,S"
    })
    void given_a_direction_when_right_returns_right_direction(String inputDirection, String outputDirection) {
        Direction expected = getDirection(outputDirection);
        Direction current = getDirection(inputDirection);
        assertEquals(expected, navigator.getRight(current));
    }

    @ParameterizedTest
    @CsvSource({
            "10,10,1,0,1,10",
            "10,10,0,1,10,1",
            "1,1,-1,0,10,1",
            "1,1,0,-1,1,10",
            "1,1,1,1,2,2"
    })
    void a_move_at_the_edge_of_the_grid_wraps_around(int currentX, int currentY, int xModifier, int yModifier, int expectedX, int expectedY) {
        navigator = new Navigator(10,10);
        Position actualPosition = navigator.getPosition(new Position(currentX,currentY), xModifier, yModifier);
        assertEquals(new Position(expectedX, expectedY), actualPosition);
    }
}
