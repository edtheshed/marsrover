package e.rixon.kata;

import static e.rixon.kata.Direction.*;

public class Rover {
    private int xPosition;
    private int yPosition;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.xPosition = x;
        this.yPosition = y;
        this.direction = direction;
    }

    public void move() {
        if (NORTH.equals(direction))
            yPosition++;
        if (SOUTH.equals(direction))
            yPosition--;
        if (EAST.equals(direction))
            xPosition++;
        if (WEST.equals(direction))
            xPosition--;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", xPosition, yPosition, direction);
    }

}

enum Direction {
    NORTH("N"),
    EAST("E"),
    WEST("W"),
    SOUTH("S");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return direction;
    }
}