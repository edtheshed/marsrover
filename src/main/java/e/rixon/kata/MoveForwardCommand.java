package e.rixon.kata;

class MoveForwardCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        return rover.moveForward();
    }
}
