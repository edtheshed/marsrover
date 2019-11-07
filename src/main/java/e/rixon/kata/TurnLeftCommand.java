package e.rixon.kata;

class TurnLeftCommand implements Command {
    @Override
    public boolean execute(Rover rover) {
        rover.turnLeft();
        return true;
    }
}
