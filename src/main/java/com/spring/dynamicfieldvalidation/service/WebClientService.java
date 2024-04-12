package com.spring.dynamicfieldvalidation.service;
import com.spring.dynamicfieldvalidation.dto.EntitiesListDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientService{
    private final WebClient webClient;

    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9091").build();
    }
    public EntitiesListDTO fetchData() {
        EntitiesListDTO entitiesListDTO = webClient
                .get()
                .uri("/entitiesList")
                .retrieve()
                .bodyToMono(EntitiesListDTO.class)
                .block(); // Block to wait for the response
        return entitiesListDTO;
    }
}
