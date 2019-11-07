package e.rixon.kata;

import java.util.*;

public class MarsRoverService {

    private List<Position> obstacles;
    private int xGridSize;
    private int yGridSize;

    private Map<Rover, String> roverStringMap;
    private boolean movesRan = false;

    public MarsRoverService(int xGridSize, int yGridSize, Position... obstacles) {
        this.xGridSize = xGridSize;
        this.yGridSize = yGridSize;
        this.obstacles = Arrays.asList(obstacles);
        roverStringMap = new HashMap<>();
    }

    public void setRover(int x, int y, Direction direction) {
        setRover(x, y, direction, "");
    }

    public void setRover(int x, int y, Direction direction, String moves) {
        roverStringMap.put(new Rover(new Position(x, y), direction, new Navigator(xGridSize, yGridSize, obstacles)), moves);
    }

    private void runRovers() {
        for (Map.Entry<Rover, String> roverMoveEntry : roverStringMap.entrySet()) {
            Rover rover = roverMoveEntry.getKey();
            char[] moveArray = roverMoveEntry.getValue().toCharArray();
            for (char move : moveArray) {
                if ('M' == move) {
                    if (!rover.moveForward()) {
                        break;
                    }
                }
                if ('L' == move) {
                    rover.turnLeft();
                }
                if ('R' == move)
                    rover.turnRight();
            }
        }
    }

    public String getOutput() {
        if (!movesRan) {
            runRovers();
            movesRan = true;
        }

        Set<Rover> rovers = roverStringMap.keySet();
        return rovers.stream()
                .map(Rover::toString)
                .reduce((s1, s2) -> s1 + System.lineSeparator() + s2)
                .orElse("");
    }


}
