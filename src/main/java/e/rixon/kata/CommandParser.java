package e.rixon.kata;

import java.util.List;

public interface CommandParser<T> {
    List<Command> parseCommands(T command);
}
