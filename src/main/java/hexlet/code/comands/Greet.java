package hexlet.code.comands;

public final class Greet implements Command {
    @Override
    public String toString() {
        return "Greet";
    }

    @Override
    public boolean run() {
        System.out.println("Hi");

        return true;
    }
}
