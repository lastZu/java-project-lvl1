package hexlet.code;

public final class Data {
    private final String question;
    private final String answer;

    public Data(String currentQuestion, String currentAnswer) {
        this.question = currentQuestion;
        this.answer = currentAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
