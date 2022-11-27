package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "inventoryItem")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemModel {
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String description;

    @Field
    private String email;

    @Field
    private int quantity = 0;

    public InventoryItemModel(String name, String description, String email) {
        this.name = name;
        this.description = description;
        this.email = email;
    }

    @Override
    public String toString() {
        return "InventoryItemModel [description=" + description + ", id=" + id + ", name=" + name
                + "]";
    }
}
