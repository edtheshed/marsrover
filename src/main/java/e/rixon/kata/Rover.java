package e.rixon.kata;

import static e.rixon.kata.Direction.*;

public class Rover {
    private Position position;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this(new Position(x, y), direction);
    }

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move() {
        if (NORTH.equals(direction))
            position.setY(position.getY()+1);
        if (SOUTH.equals(direction))
            position.setY(position.getY()-1);
        if (EAST.equals(direction))
            position.setX(position.getX()+1);
        if (WEST.equals(direction))
            position.setX(position.getX()-1);
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