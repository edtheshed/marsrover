package e.rixon.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarsRoverService {

    private List<Position> obstacles;
    private int xGridSize;
    private int yGridSize;
    private List<Rover> rovers;
    private List<String> moveList;
    private boolean movesRan = false;

    public MarsRoverService(int xGridSize, int yGridSize, Position... obstacles) {
        this.xGridSize = xGridSize;
        this.yGridSize = yGridSize;
        this.obstacles = Arrays.asList(obstacles);
        rovers = new ArrayList<>();
        moveList = new ArrayList<>();
    }

    public void setRover(int x, int y, Direction direction) {
        obstacles.add()
        setRover(new Rover(new Position(x, y), direction, new Navigator(xGridSize, yGridSize, obstacles)));
    }

    public void setRover(Rover rover) {
        rovers.add(rover);
    }

    public void moveRover(String moves) {
        moveList.add(moves);
    }

    private void callMove(List<String> moves) {
        for (String moveString : moves) {
            int moveListIndex = 0;
            char[] moveArray = moveString.toCharArray();
            for (char move : moveArray) {
                if ('M' == move) {
                    if (!rovers.get(moveListIndex).moveForward()) {
                        break;
                    }
                }
                if ('L' == move) {
                    rovers.get(moveListIndex).turnLeft();
                }
                if ('R' == move)
                    rovers.get(moveListIndex).turnRight();
            }
        }
    }

    public String getOutput() {
        if (!movesRan) {
            callMove(moveList);
            movesRan = true;
        }

        StringBuilder str = new StringBuilder();
        for (Rover rover : rovers) {
            str.append(rover.toString() + "\n");
        }

        return str.toString();
    }
}
