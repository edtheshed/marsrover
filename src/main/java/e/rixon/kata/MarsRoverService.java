package e.rixon.kata;

public class MarsRoverService {
    private int xGridSize;
    private int yGridSize;
    private Rover rover;

    public MarsRoverService(int xGridSize, int yGridSize) {
        this.xGridSize = xGridSize;
        this.yGridSize = yGridSize;
    }

    public void setRover(int x, int y, Direction direction) {
        setRover(new Rover(new Position(x,y), direction, new Navigator()));
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public void moveRover(String moves) {
        char[] moveArray = moves.toCharArray();
        for(char move : moveArray){
            if ('M' == move)
                rover.moveForward();
            if ('L' == move)
                rover.turnLeft();
            if ('R' == move)
                rover.turnRight();
        }
    }

    public String getOutput() {
        return rover.toString();
    }
}
