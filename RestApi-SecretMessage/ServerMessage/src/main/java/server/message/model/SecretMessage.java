package server.message.model;

public class SecretMessage {
    private String text;

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
