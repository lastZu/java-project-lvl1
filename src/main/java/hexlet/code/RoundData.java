package hexlet.code;

public final class RoundData {
    private final String question;
    private final String answer;

    public RoundData(String questionParam, String answerParam) {
        this.question = questionParam;
        this.answer = answerParam;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
