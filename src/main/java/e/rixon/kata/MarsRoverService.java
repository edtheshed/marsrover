package e.rixon.kata;

import java.util.Arrays;
import java.util.List;

public class MarsRoverService {

    private List<Position> obstacles;
    private int xGridSize;
    private int yGridSize;
    private Rover rover;
    private boolean obstacleFlag = false;

    public MarsRoverService(int xGridSize, int yGridSize, Position... obstacles) {
        this.xGridSize = xGridSize;
        this.yGridSize = yGridSize;
        this.obstacles = Arrays.asList(obstacles);
    }

    public void setRover(int x, int y, Direction direction) {
        setRover(new Rover(new Position(x,y), direction, new Navigator(xGridSize, yGridSize, obstacles)));
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public void moveRover(String moves) {
        char[] moveArray = moves.toCharArray();
        for(char move : moveArray){
            if ('M' == move) {
                if(!rover.moveForward()) {
                    obstacleFlag = true;
                    break;
                }
            }
            if ('L' == move)
                rover.turnLeft();
            if ('R' == move)
                rover.turnRight();
        }
    }

    public String getOutput() {
        return obstacleFlag ? "O " + rover.toString() : rover.toString();
    }
}
