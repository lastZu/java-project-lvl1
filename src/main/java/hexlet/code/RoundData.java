package hexlet.code;

public final class RoundData {
    private final String question;
    private final String answer;

    public RoundData(String problem, String reply) {
        this.question = problem;
        this.answer = reply;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
