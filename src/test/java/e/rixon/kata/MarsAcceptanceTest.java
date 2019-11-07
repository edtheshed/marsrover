package e.rixon.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsAcceptanceTest {

    @Test
    void rover_can_move_on_a_grid() {
        MarsRoverService service = new MarsRoverService(10, 10);
        service.setRover(5, 5, Direction.NORTH, "LMLMRMLMRRMMMLMM");
        service.parseCommandsAndExecuteCommands();
        assertEquals("1 6 W", service.getOutput());
    }

    @Test
    void rover_can_finish_where_it_started_if_only_move_forward() {
        MarsRoverService service = new MarsRoverService(3, 3);
        service.setRover(1, 1, Direction.NORTH, "MMMLMMM");
        service.parseCommandsAndExecuteCommands();
        assertEquals("1 1 W", service.getOutput());
    }

    @Test
    void rover_cant_pass_through_an_obstacle() {
        MarsRoverService service = new MarsRoverService(3, 3, new Position(1, 3));
        service.setRover(1, 1, Direction.NORTH, "MMM");
        service.parseCommandsAndExecuteCommands();
        assertEquals("O 1 2 N", service.getOutput());
    }

//    @Test
    void rover_cant_pass_through_another_rover() {
        MarsRoverService service = new MarsRoverService(5, 4);
        service.setRover(1, 1, Direction.NORTH, "MMMM");
        service.setRover(1, 3, Direction.NORTH, "MMMM");
        service.parseCommandsAndExecuteCommands();
        assertEquals("O 1 2 N\nO 1 1 N", service.getOutput());
    }
}
