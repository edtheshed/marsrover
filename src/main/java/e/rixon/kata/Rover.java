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

    private Navigator navigator;

    public Rover(Position position, Direction direction, Navigator navigator) {
        this.position = position;
        this.direction = direction;
        this.navigator = navigator;
    }

    public boolean moveForward() {
        for(Map.Entry<Direction, PositionVector> directionVector: positionVectorMap.entrySet()) {
            Direction direction = directionVector.getKey();
            if(direction.equals(this.direction)) {
                PositionVector vector = directionVector.getValue();
                Position newPosition = navigator.getPosition(position, vector.getxModifier(), vector.getyModifier());
                if (this.position.equals(newPosition))
                    return false;
                this.position = newPosition;
                return true;
            }
        }
        throw new IllegalStateException("Unsupported direction");
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", position.getX(), position.getY(), direction);
    }

    public void turnLeft() {
        this.direction = navigator.getLeft(direction);
    }

    public void turnRight() {
        this.direction = navigator.getRight(direction);
    }
}

