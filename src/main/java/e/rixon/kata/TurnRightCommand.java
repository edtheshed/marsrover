package e.rixon.kata;

public class TurnRightCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        rover.turnRight();
        return true;
    }
}
