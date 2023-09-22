package textadventure.commands;

public class GoCommand implements Command {
    private final String direction;

    public GoCommand(String direction) {
        this.direction = direction;
    }

    @Override
    public void execute() {
        System.out.println("You go " + direction + ".");
    }
}