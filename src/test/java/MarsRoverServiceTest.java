import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverServiceTest {

    @Test
    void placing_a_rover_and_get_output_should_return_the_rover_location() {
        MarsRoverService service1 = new MarsRoverService(10, 10);
        service1.setRover(1, 1, "N");
        assertEquals("1 1 N", service1.getOutput());

        MarsRoverService service2 = new MarsRoverService(10, 10);
        service2.setRover(2, 2, "W");
        assertEquals("2 2 W", service2.getOutput());
    }

    @Test
    void moving_a_placed_rover_and_get_output_should_return_new_location() {
        MarsRoverService service1 = new MarsRoverService(10, 10);
        service1.setRover(1, 1, "N");
        service1.moveRover("M");
        assertEquals("1 2 N", service1.getOutput());

        MarsRoverService service2 = new MarsRoverService(10, 10);
        service2.setRover(2, 2, "S");
        service2.moveRover("M");
        assertEquals("2 1 S", service2.getOutput());
    }
}
