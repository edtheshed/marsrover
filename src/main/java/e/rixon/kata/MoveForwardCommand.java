package e.rixon.kata;

public class MoveForwardCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        return rover.moveForward();
    }
}
