package e.rixon.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static e.rixon.kata.DirectionUtility.getDirection;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigatorTest {

    private Navigator navigator;

    @BeforeEach
    void setUp() {
        navigator = new Navigator();
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
}
