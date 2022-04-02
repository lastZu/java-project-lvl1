package hexlet.code;

public class Utils {
    public static int getRandomInteger(int fromInclusive, int toExclusive) {
        return (int) (Math.random() * (toExclusive - fromInclusive)) + fromInclusive;
    }

    public static RoundData calculate(int x, int y, char operation) {
        String question = "0 + 0";
        int answer = 0;

        if (operation == '+') {
            answer = x + y;
            question = " + ";
        } else if (operation == '-') {
            answer = x - y;
            question = " - ";
        } else if (operation == '*') {
            answer = x * y;
            question = " * ";
        }
        question = x + question + y;

        return new RoundData(question, Integer.toString(answer));
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] getArithmeticSequence(int startValue, int step, int length) {
        int[] sequence = new int[length];
        for (int j = 0; j < length; j++) {
            sequence[j] = startValue + j * step;
        }

        return sequence;
    }
}
