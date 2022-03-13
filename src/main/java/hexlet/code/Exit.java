package hexlet.code;

public final class Exit implements Command {
    @Override
    public String toString() {
        return "Exit";
    }

    @Override
    public boolean run() {
        System.out.println("Exit");

        return false;
    }
}
