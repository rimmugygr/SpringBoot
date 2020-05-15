package gradle.reactiv;


import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.server.HttpServer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


public class ReactiveApplication {
	private final AtomicInteger counter = new AtomicInteger(0);
	private final MessageBoardService messageService = new MessageBoardService();

	public static void main(String[] args) {
		new ReactiveApplication().serve();
	}

	private void serve() {
		RouterFunction route = nest(path("/api"),
				route(GET("/"),renderWelcome())
				.andRoute(GET("/time"), renderTime())
				.andRoute(GET("/topic"), renderAllTopics())
				.andRoute(GET("/message/{topic}"),renderMessage())
				.andRoute(POST("/message/{topic}"),postMessage()));

		HttpHandler httpHandler = RouterFunctions.toHttpHandler(route);
		HttpServer server = HttpServer.create("localhost",8080);
		server.startAndAwait(new ReactorHttpHandlerAdapter(httpHandler));
	}

	private HandlerFunction<ServerResponse> renderAllTopics() {
		return request -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromObject(messageService.getAllTopics()));
	}

	private HandlerFunction<ServerResponse> renderMessage() {
		return request -> {
			final String topicName = request.pathVariable("topic");
			return ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(fromObject(messageService.getTopic(topicName)));
		};
	}

	private HandlerFunction<ServerResponse> postMessage() {
		return request -> {
			final String topicName = request.pathVariable("topic");
			Mono<Message> postedMessage = request.bodyToMono(Message.class);
			return postedMessage.flatMap(
					message -> ServerResponse.ok()
							.contentType(MediaType.APPLICATION_JSON)
							.body(fromObject(messageService.addMessageToTopic(topicName,message)))
			);
		};
	}

	private HandlerFunction<ServerResponse> renderTime() {
		return request -> {
			String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
			return ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(fromObject(time));
		};
	}

	private HandlerFunction<ServerResponse> renderWelcome() {
		return request -> {
			Optional<String> userName = request.queryParam("name");
			String hello = "hello " + userName.orElse(" unknown");
			String visit = "<br> It " + counter.getAndIncrement() + "visit";
			String form = "<br> <form><input type='text' name='name'/><input type='submit' value='send'/></form>";
			return ServerResponse.ok()
					.contentType(MediaType.TEXT_HTML)
					.body(fromObject(hello + visit + form));
		};
	}

}

