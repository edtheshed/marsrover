package e.rixon.kata;

import java.util.Map;

import static e.rixon.kata.Direction.*;

public class Rover {
    private Position position;
    private Direction direction;
    private final Map<Direction, PositionVector> positionVectorMap = Map.of(
            NORTH, new PositionVector(0, 1),
            SOUTH, new PositionVector(0, -1),
            EAST, new PositionVector(1, 0),
            WEST, new PositionVector(-1, 0));

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public void move() {
        for(Map.Entry<Direction, PositionVector> directionVector: positionVectorMap.entrySet()) {
            Direction direction = directionVector.getKey();
            if(direction.equals(this.direction)) {
                PositionVector vector = directionVector.getValue();
                this.position = position.move(vector.getxModifier(), vector.getyModifier());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", position.getX(), position.getY(), direction);
    }
}

class PositionVector {
    private final int xModifier;
    private final int yModifier;

    PositionVector(int xModifier, int yModifier) {
        this.xModifier = xModifier;
        this.yModifier = yModifier;
    }

    public int getxModifier() {
        return xModifier;
    }

    public int getyModifier() {
        return yModifier;
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