package gradle.reactiv.model;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String name;
    private List<Message> messages = new ArrayList<>();

    public Topic(String name, List<Message> messages) {
        this.name = name;
        this.messages = messages;
    }

    public Topic(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        List<Message> newList = new ArrayList<>(this.messages);
        newList.add(message);
        this.messages = newList;
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
