package e.rixon.kata;

class TurnRightCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        rover.turnRight();
        return true;
    }
}
