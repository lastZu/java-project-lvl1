package hexlet.code;

public class Utils {
    public static int getRandomInteger(int fromInclusive, int toExclusive) {
        return (int) (Math.random() * (toExclusive - fromInclusive)) + fromInclusive;
    }
}
