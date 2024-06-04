package dev.igor.cosmos.repository;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import dev.igor.cosmos.Item;

@Repository
public interface ItemRepository extends CosmosRepository<Item, String> {
}
