public class MarsRoverService {
    private int xPosition;
    private int yPosition;
    private String direction;

    public MarsRoverService(int xGridSize, int yGridSize) {
    }

    public void setRover(int x, int y, String direction) {
        this.xPosition = x;
        this.yPosition = y;
        this.direction = direction;
    }

    public void moveRover(String moves) {
        //char[] moveArray = moves.toCharArray();
//        for (char move : moveArray) {
            if (direction == "N")
                yPosition++;
            if (direction == "S")
                yPosition--;
    }


    public String getOutput() {
        return String.format("%s %s %s", xPosition, yPosition, direction);
    }
}
