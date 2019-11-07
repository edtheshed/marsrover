package e.rixon.kata;

class CharacterCommandParser implements CommandParser<Character> {
    @Override
    public Command parseCommand(Character command) {
        return switch (command) {
            case 'M' -> new MoveForwardCommand();
            case 'L' -> new TurnLeftCommand();
            case 'R' -> new TurnRightCommand();
            default -> throw new IllegalStateException("Unexpected value: " + command);
        };
    }
}
