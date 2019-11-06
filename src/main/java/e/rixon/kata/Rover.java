package e.rixon.kata;

public class Rover {
    private int xPosition;
    private int yPosition;
    private String direction;

    public Rover(int x, int y, String direction) {
        this.xPosition = x;
        this.yPosition = y;
        this.direction = direction;
    }

    public void move() {
        if ("N".equals(direction))
            yPosition++;
        if ("S".equals(direction))
            yPosition--;
        if ("E".equals(direction))
            xPosition++;
        if ("W".equals(direction))
            xPosition--;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", xPosition, yPosition, direction);
    }

}
