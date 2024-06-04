package dev.igor.cosmos.env;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "azure.cosmos")
@Getter
@Setter
public class CosmosEnv {
    private String uri;
    private String key;
    private String database;
}
