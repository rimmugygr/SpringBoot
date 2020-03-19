package boot.application.model;

public class SecretMessage {
    private String text;

    public SecretMessage() {
    }

    public SecretMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
