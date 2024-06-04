package dev.igor.cosmos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

import dev.igor.cosmos.env.CosmosEnv;

@Configuration
@EnableCosmosRepositories(basePackages = "dev.igor.cosmos.repository")
public class CosmosDbConfig extends AbstractCosmosConfiguration {
    private final CosmosEnv env;
    private AzureKeyCredential azureKeyCredential;

    public CosmosDbConfig(CosmosEnv env) {
        this.env = env;
    }

    @Bean
    public CosmosClientBuilder getCosmosClientBuilder() {
        this.azureKeyCredential = new AzureKeyCredential(env.getKey());
        DirectConnectionConfig directConnectionConfig = new DirectConnectionConfig();
        GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
        return new CosmosClientBuilder()
            .endpoint(env.getUri())
            .credential(azureKeyCredential)
            .directMode(directConnectionConfig, gatewayConnectionConfig);
    }

    @Override
    protected String getDatabaseName() {
        return env.getDatabase();
    }
}
