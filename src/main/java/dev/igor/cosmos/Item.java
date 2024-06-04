package dev.igor.cosmos;

import com.azure.spring.data.cosmos.core.mapping.Container;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Container(containerName = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private String id;
    private String description;
}
