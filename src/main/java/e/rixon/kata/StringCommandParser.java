package e.rixon.kata;

import java.util.ArrayList;
import java.util.List;

class StringCommandParser implements CommandParser<String> {
    @Override
    public List<Command> parseCommands(String commands) {
        List<Command> commandList = new ArrayList<>();
        for(Character command : commands.toCharArray()) {
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
