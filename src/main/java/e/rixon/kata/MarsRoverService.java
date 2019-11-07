package e.rixon.kata;

import java.util.*;

public class MarsRoverService {

    private List<Position> obstacles;
    private int xGridSize;
    private int yGridSize;

    private Map<Rover, String> roverStringMap;
    private CommandParser<Character> commandParser = new CharacterCommandParser();

    public MarsRoverService(int xGridSize, int yGridSize, Position... obstacles) {
        this.xGridSize = xGridSize;
        this.yGridSize = yGridSize;
        this.obstacles = Arrays.asList(obstacles);
        roverStringMap = new HashMap<>();
    }

    public void setRover(int x, int y, Direction direction) {
        setRover(x, y, direction, "");
    }

    public void setRover(int x, int y, Direction direction, String moves) {
        roverStringMap.put(new Rover(new Position(x, y), direction, new Navigator(xGridSize, yGridSize, obstacles)), moves);
    }

    public void parseCommandsAndExecuteCommands() {
        for (Map.Entry<Rover, String> roverMoveEntry : roverStringMap.entrySet()) {
            Rover rover = roverMoveEntry.getKey();
            char[] moveArray = roverMoveEntry.getValue().toCharArray();
            for (char move : moveArray) {
                commandParser.parseCommand(move).execute(rover);
            }
        }
    }

    public String getOutput() {
        Set<Rover> rovers = roverStringMap.keySet();
        return rovers.stream()
                .map(Rover::toString)
                .reduce((s1, s2) -> s1 + System.lineSeparator() + s2)
                .orElse("");
    }

}
