package e.rixon.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static e.rixon.kata.DirectionUtility.getDirection;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverServiceTest {

    MarsRoverService service;

    @Test
    void placing_a_rover_and_get_output_should_return_the_rover_location() {
        given_a_mars_rover_service(10, 10);
        given_a_rover_with(1, 1, Direction.NORTH);
        then_the_rover_is_at("1 1 N");

        given_a_mars_rover_service(10, 10);
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
        given_a_mars_rover_service(10, 10);
        given_a_rover_with(x, y, getDirection(direction), asList(new MoveForwardCommand()));
        service.executeCommands();
        then_the_rover_is_at(expectedOutput);
    }

    private void given_a_rover_with(int x, int y, Direction direction, List<Command> commands) {
        service.setRover(x, y, direction, commands);
    }

    private void given_a_rover_with(int x, int y, Direction direction, String commands) {
        given_a_rover_with(x, y, direction, CommandUtility.parseCommands(commands));
    }

    private void given_a_rover_with(int x, int y, Direction direction) {
        service.setRover(x, y, direction);
    }

    private void given_a_mars_rover_service(int xGridSize, int yGridSize) {
        this.service = new MarsRoverService(xGridSize, yGridSize);
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,N,MM,1 3 N",
            "2,5,S,MMMM,2 1 S",
            "1,1,E,MMM,4 1 E",
            "6,2,W,MMMMM,1 2 W"
    })
    void moving_a_rover_more_than_1_square_should_return_new_location(int x, int y, String direction, String moves, String expectedOutput) {
        given_a_mars_rover_service(10, 10);
        given_a_rover_with(x, y, getDirection(direction), moves);
        service.executeCommands();
        then_the_rover_is_at(expectedOutput);
    }

    @ParameterizedTest
    @CsvSource({
            "ML,3 4 W",
            "MR,3 4 E"
    })
    void moving_and_turning_a_rover_should_return_new_location(String moves, String expectedOutput) {
        given_a_mars_rover_service(10, 10);
        given_a_rover_with(3, 3, Direction.NORTH, moves);
        service.executeCommands();
        then_the_rover_is_at(expectedOutput);
    }

    @Test
    void rover_can_finish_where_it_started_if_only_move_forward() {
        given_a_mars_rover_service(3, 3);
        given_a_rover_with(1, 1, Direction.NORTH, "MMM");
        service.executeCommands();
        then_the_rover_is_at("1 1 N");
    }
}
