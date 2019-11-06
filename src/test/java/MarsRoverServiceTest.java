import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverServiceTest {

    MarsRoverService service;
    @Test
    void placing_a_rover_and_get_output_should_return_the_rover_location() {
        given_a_mars_rover_service();
        given_a_rover_with(1, 1, "N");
        then_the_rover_is_at("1 1 N");

        given_a_mars_rover_service();
        given_a_rover_with(2, 2,"W");
        then_the_rover_is_at("2 2 W");
    }

    private void then_the_rover_is_at(String s) {
        assertEquals(s, service.getOutput());
    }

    @Test
    void moving_a_placed_rover_and_get_output_should_return_new_location() {
        given_a_mars_rover_service();
        given_a_rover_with(1, 1,"N");
        when_the_rover_moves();
        then_the_rover_is_at("1 2 N");

        given_a_mars_rover_service();
        given_a_rover_with(2, 2,"S");
        when_the_rover_moves();
        then_the_rover_is_at("2 1 S");
    }

    private void when_the_rover_moves() {
        service.moveRover("M");
    }

    private void given_a_rover_with(int x, int y, String n) {
        service.setRover(x, y, n);
    }

    private void given_a_mars_rover_service() {
        this.service = new MarsRoverService(10, 10);
    }

    @Test
    void moving_a_rover_1_step_from_1_1_E_and_get_output_should_return_2_1_E() {

    }
}
