package server.message.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "server.message")
public class ServerMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerMessageApplication.class, args);
	}

}
