package e.rixon.kata;

import e.rixon.kata.MarsRoverService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsAcceptanceTest {

    @Test
    void roverCanMoveOnAGrid() {
        MarsRoverService service = new MarsRoverService(5, 5);
        service.setRover(1, 2, Direction.NORTH);
        service.moveRover("LMLMLMLMM");
        assertEquals("1 3 N", service.getOutput());
    }
}
