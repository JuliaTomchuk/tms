package com.example.service2_rest.config;


import com.example.service2_rest.exception.ClientException;
import com.example.service2_rest.exception.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Optional;

@Configuration
public class FeignConfig {
    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            Integer status = Optional.ofNullable(response).map(Response::status).orElseThrow();
            if (status == 404) {
                ObjectMapper objectMapper = new ObjectMapper();
                ErrorResponse errorResponse;
                try {
                    errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                throw new ClientException(errorResponse.getError());
            }

            throw new ClientException("Unexpected error");

        };

    }
}
