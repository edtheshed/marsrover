package e.rixon.kata;

public interface CommandParser<T> {
    Command parseCommand(T command);
}
