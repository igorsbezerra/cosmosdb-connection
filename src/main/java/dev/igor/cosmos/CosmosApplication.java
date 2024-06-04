package dev.igor.cosmos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.igor.cosmos.repository.ItemRepository;

@SpringBootApplication(scanBasePackages = "dev.igor.cosmos")
public class CosmosApplication implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(CosmosApplication.class);
	private ItemRepository repository;
	
	public CosmosApplication(ItemRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CosmosApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// repository.save(new Item("20", "Moto"));

		Iterable<Item> all = repository.findAll();

		all.forEach(item -> LOGGER.info("{}", item));
		
	}
}
