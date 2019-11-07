package e.rixon.kata;

import e.rixon.kata.Command;
import e.rixon.kata.MoveForwardCommand;
import e.rixon.kata.TurnLeftCommand;
import e.rixon.kata.TurnRightCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandUtility {
    public static List<Command> parseCommands(String commands) {
        List<Command> commandList = new ArrayList<>();
        for(char command: commands.toCharArray()) {
            Command parsedCommand = switch (command) {
                case 'M' -> new MoveForwardCommand();
                case 'L' -> new TurnLeftCommand();
                case 'R' -> new TurnRightCommand();
                default -> throw new IllegalStateException("Unexpected value: " + command);
            };
            commandList.add(parsedCommand);
        }
        return commandList;
    }
}
