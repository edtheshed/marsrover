package e.rixon.kata;

public class DirectionUtility {
    public static Direction getDirection(String direction) {
        if("N".equals(direction)) return Direction.NORTH;
        if("W".equals(direction)) return Direction.WEST;
        if("E".equals(direction)) return Direction.EAST;
        if("S".equals(direction)) return Direction.SOUTH;
        throw new IllegalArgumentException("unknown direction " + direction);
    }
}
