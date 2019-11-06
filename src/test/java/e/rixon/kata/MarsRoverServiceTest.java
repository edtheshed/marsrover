package e.rixon.kata;

import e.rixon.kata.MarsRoverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverServiceTest {

    MarsRoverService service;

    @Test
    void placing_a_rover_and_get_output_should_return_the_rover_location() {
        given_a_mars_rover_service();
        given_a_rover_with(1, 1, Direction.NORTH);
        then_the_rover_is_at("1 1 N");

        given_a_mars_rover_service();
        given_a_rover_with(2, 2,Direction.WEST);
        then_the_rover_is_at("2 2 W");
    }

    private void then_the_rover_is_at(String s) {
        assertEquals(s, service.getOutput());
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,N,1 2 N",
            "2,2,S,2 1 S",
            "1,1,E,2 1 E",
            "2,2,W,1 2 W"
    })
    void moving_a_placed_rover_and_get_output_should_return_new_location(int x, int y, String direction, String expectedOutput) {
        given_a_mars_rover_service();
        given_a_rover_with(x, y, getDirection(direction));
        when_the_rover_moves();
        then_the_rover_is_at(expectedOutput);
    }

    private Direction getDirection(String direction) {
        if("N".equals(direction)) return Direction.NORTH;
        if("W".equals(direction)) return Direction.WEST;
        if("E".equals(direction)) return Direction.EAST;
        if("S".equals(direction)) return Direction.SOUTH;
        throw new IllegalArgumentException("unknown direction " + direction);
    }

    private void when_the_rover_moves() {
        service.moveRover("M");
    }

    private void given_a_rover_with(int x, int y, Direction direction) {
        service.setRover(x, y, direction);
    }

    private void given_a_mars_rover_service() {
        this.service = new MarsRoverService(10, 10);
    }

}
