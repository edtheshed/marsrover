package e.rixon.kata;

public class MarsRoverService {
    private Rover rover;

    public MarsRoverService(int xGridSize, int yGridSize) {
    }

    public void setRover(int x, int y, Direction direction) {
        setRover(new Rover(new Position(x,y), direction));
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public void moveRover(String moves) {
        char[] moveArray = moves.toCharArray();
        for(char move : moveArray){
            if ('M' == move)
                rover.move();
            if ('L' == move)
                rover.turnLeft();
        }
    }

    public String getOutput() {
        return rover.toString();
    }
}
