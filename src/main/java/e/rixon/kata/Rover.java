package e.rixon.kata;

import static e.rixon.kata.Direction.*;

public class Rover {
    private Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move() {
        if (NORTH.equals(direction))
            this.position = position.move(0, 1);
        if (SOUTH.equals(direction))
            this.position = position.move(0, -1);
        if (EAST.equals(direction))
            this.position = position.move(1, 0);
        if (WEST.equals(direction))
            this.position = position.move(-1, 0);

    }

    @Override
    public String toString() {
        return String.format("%s %s %s", position.getX(), position.getY(), direction);
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