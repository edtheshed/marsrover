package e.rixon.kata;

import java.util.Map;

public class DirectionFinder {
    Map<Direction, Direction> leftMap;
    Map<Direction, Direction> rightMap;

    public DirectionFinder() {
        this.leftMap = Map.of(
                Direction.NORTH, Direction.WEST,
                Direction.WEST, Direction.SOUTH,
                Direction.SOUTH, Direction.EAST,
                Direction.EAST, Direction.NORTH
        );
        this.rightMap = Map.of(
                Direction.NORTH, Direction.EAST,
                Direction.WEST, Direction.NORTH,
                Direction.SOUTH, Direction.WEST,
                Direction.EAST, Direction.SOUTH
        );
    }

    public Direction getLeft(Direction direction) {
        return leftMap.get(direction);
    }

    public Direction getRight(Direction direction) {
        return rightMap.get(direction);
    }
}