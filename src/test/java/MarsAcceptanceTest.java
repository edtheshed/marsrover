import org.junit.jupiter.api.Test;

import javax.imageio.ImageWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsAcceptanceTest {

    @Test
    void roverCanMoveOnAGrid() {
        MarsRoverService service = new MarsRoverService(5, 5);
        service.setRover(1, 2, "N");
        service.moveRover("LMLMLMLMM");
        assertEquals("1 3 N", service.getOutput());
    }
}
