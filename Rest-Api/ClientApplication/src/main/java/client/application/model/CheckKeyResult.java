package client.application.model;

public class CheckKeyResult {
    private boolean isCorrect;

    public CheckKeyResult() {
    }

    public CheckKeyResult(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
