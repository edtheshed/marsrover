package e.rixon.kata;

public class TurnLeftCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        rover.turnLeft();
        return true;
    }
}
