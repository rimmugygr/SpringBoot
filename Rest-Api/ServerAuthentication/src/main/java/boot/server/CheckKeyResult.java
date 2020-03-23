package boot.server;

public class CheckKeyResult {
    private boolean isCorrect;

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
