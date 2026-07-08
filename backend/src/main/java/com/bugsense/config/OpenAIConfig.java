package com.bugsense.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;

import io.github.cdimascio.dotenv.Dotenv;

@Configuration
public class OpenAIConfig {

    @Bean
    public OpenAIClient openAIClient() {

        Dotenv dotenv = Dotenv.load();

        return OpenAIOkHttpClient.builder()
                .apiKey(dotenv.get("OPENAI_API_KEY"))
                .build();
    }
}