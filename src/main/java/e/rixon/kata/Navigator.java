package e.rixon.kata;

public class Navigator {

    final DirectionFinder directionFinder = new DirectionFinder();
    private final int xBound;
    private final int yBound;

    public Navigator(int xBound, int yBound) {
        this.xBound = xBound;
        this.yBound = yBound;
    }

    public Direction getLeft(Direction direction) {
        return directionFinder.getLeft(direction);
    }

    public Direction getRight(Direction direction) {
        return directionFinder.getRight(direction);
    }

    public Position getPosition(Position currentPosition, int initialXModifier, int initialYModifier) {
        if(currentPosition.getX() + initialXModifier > xBound)
            return new Position(1, currentPosition.getY());
        if(currentPosition.getY() + initialYModifier > yBound)
            return new Position(currentPosition.getX(), 1);
        if(currentPosition.getX() + initialXModifier < 1)
            return new Position(xBound, currentPosition.getY());
        if(currentPosition.getY() + initialYModifier < 1)
            return new Position(currentPosition.getX(), yBound);
        return currentPosition.move(initialXModifier, initialYModifier);
    }
}