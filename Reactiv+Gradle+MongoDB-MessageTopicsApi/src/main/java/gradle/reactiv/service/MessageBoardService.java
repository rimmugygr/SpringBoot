package gradle.reactiv.service;

import gradle.reactiv.SpringInit;
import gradle.reactiv.model.BoardMessage;
import gradle.reactiv.model.Message;
import gradle.reactiv.model.Topic;
import gradle.reactiv.repository.BoardMessageRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MessageBoardService {
    private Map<String, Topic> topics = new HashMap<>();
    private final BoardMessageRepository messageRepository;


    public MessageBoardService() {
//        // initial list of topic
//        this.topics = List.of("FirstTopic","SecondTopic").stream()
//                .map(Topic::new)
//                .collect(Collectors.toMap(Topic::getName,topic -> topic));
        // init spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringInit.class);
        // get bean repository mongo
        messageRepository = context.getBean(BoardMessageRepository.class);
        // get all data from mongo
        messageRepository.findAll().forEach(
                boardMessage -> {
                    if (!topics.containsKey(boardMessage.getTopic())) {
                        topics.put(boardMessage.getTopic(), new Topic(boardMessage.getTopic() , List.of(boardMessage.getMessage())));
                    } else {
                        topics.get(boardMessage.getTopic()).addMessage(boardMessage.getMessage());
                    }
                }
        );
    }

    public synchronized Topic getTopic(String name){
        if (!this.topics.containsKey(name)){
            this.topics.put(name,new Topic(name));
        }
        return this.topics.get(name);
    }

    public synchronized Topic addMessageToTopic(String name, Message message) {
        this.getTopic(name).addMessage(message);
        messageRepository.save(new BoardMessage(name, message));
        return this.getTopic(name);
    }

    public Map<String, Topic> getTopics() {
        return topics;
    }

    public void setTopics(Map<String, Topic> topics) {
        this.topics = topics;
    }

    public Set<String> getAllTopics() {
        return this.topics.keySet();
    }
}
