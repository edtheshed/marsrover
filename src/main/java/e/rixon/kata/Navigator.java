package e.rixon.kata;

import java.util.List;

public class Navigator {

    final DirectionFinder directionFinder = new DirectionFinder();
    private final int xBound;
    private final int yBound;
    private List<Position> obstacles;

    public Navigator(int xBound, int yBound, List<Position> obstacles) {
        this.xBound = xBound;
        this.yBound = yBound;
        this.obstacles = obstacles;
    }

    public Direction getLeft(Direction direction) {
        return directionFinder.getLeft(direction);
    }

    public Direction getRight(Direction direction) {
        return directionFinder.getRight(direction);
    }

    public Position getPosition(Position currentPosition, int initialXModifier, int initialYModifier) {
        Position finalPosition = currentPosition.move(initialXModifier, initialYModifier);;
        if(currentPosition.getX() + initialXModifier > xBound)
            finalPosition = new Position(1, currentPosition.getY());
        if(currentPosition.getY() + initialYModifier > yBound)
            finalPosition = new Position(currentPosition.getX(), 1);
        if(currentPosition.getX() + initialXModifier < 1)
            finalPosition = new Position(xBound, currentPosition.getY());
        if(currentPosition.getY() + initialYModifier < 1)
            finalPosition = new Position(currentPosition.getX(), yBound);

        if (obstacles.contains(finalPosition))
            return currentPosition;

        return finalPosition;
    }
}