package gradle.reactiv;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String name;
    private List<Message> messages;

    {
        messages = new ArrayList<>();
    }

    public Topic(String name, List<Message> messages) {
        this.name = name;
        this.messages = messages;
    }

    public Topic(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
