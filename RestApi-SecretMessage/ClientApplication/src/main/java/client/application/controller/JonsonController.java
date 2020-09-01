package client.application.controller;

import client.application.model.JonsonModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class JonsonController {

    private static final String template = "hello %s";
    private final AtomicLong counter = new AtomicLong();

    //model automatically go to json because  autoconfigure by dependency
    @GetMapping("/model")
    public JonsonModel greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new JonsonModel(counter.incrementAndGet(), String.format(template, name));
    }

}
