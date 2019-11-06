package e.rixon.kata;

public class MarsRoverService {
    private Rover rover;

    public MarsRoverService(int xGridSize, int yGridSize) {
    }

    public void setRover(int x, int y, Direction direction) {
        setRover(new Rover(x, y, direction));
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public void moveRover(String moves) {
        rover.move();
    }

    public String getOutput() {
        return rover.toString();
    }
}
