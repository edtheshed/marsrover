import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverServiceTest {

    @Test
    void placing_a_rover_and_get_output_should_return_the_rover_location_and_direction() {
        MarsRoverService service = new MarsRoverService(10, 10);
        service.setRover(1, 1, "N");
        assertEquals("1 1 N", service.getOutput());
    }
}
