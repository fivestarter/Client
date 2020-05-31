package ru.fivestarter.client.user;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {

    private final WebClient webClient;

    public UserService() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:9090/api/v1/users")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public UserJson getUser() {
        return webClient.get()
                .uri("/")
                .retrieve()
                .bodyToMono(UserJson.class)
                .block();
    }
}
