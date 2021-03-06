package client.application.model;

public class JonsonModel {
    private final long id;
    private final String content;

    public JonsonModel(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
