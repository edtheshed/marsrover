package e.rixon.kata;

import java.util.*;
import java.util.Map.Entry;

import static java.util.Arrays.asList;

public class MarsRoverService {

    private List<Position> obstacles;
    private int xGridSize;
    private int yGridSize;

    private Map<Rover, List<Command>> roverCommandsMap;

    public MarsRoverService(int xGridSize, int yGridSize, Position... obstacles) {
        this.xGridSize = xGridSize;
        this.yGridSize = yGridSize;
        this.obstacles = asList(obstacles);
        roverCommandsMap = new HashMap<>();
    }

    public void setRover(int x, int y, Direction direction) {
        roverCommandsMap.put(new Rover(new Position(x, y), direction, new Navigator(xGridSize, yGridSize, obstacles)), Collections.emptyList());
    }

    public void setRover(int x, int y, Direction direction, List<Command> commands) {
        roverCommandsMap.put(new Rover(new Position(x, y), direction, new Navigator(xGridSize, yGridSize, obstacles)), commands);
    }

    public void executeCommands() {
        for (Entry<Rover, List<Command>> roverCommandsEntry : roverCommandsMap.entrySet()) {
            Rover rover = roverCommandsEntry.getKey();
            List<Command> commands = roverCommandsEntry.getValue();
            for(Command command: commands) {
                command.execute(rover);
            }
        }
    }

    public String getOutput() {
        Set<Rover> rovers = roverCommandsMap.keySet();
        return rovers.stream()
                .map(Rover::toString)
                .reduce((s1, s2) -> s1 + System.lineSeparator() + s2)
                .orElse("");
    }

}