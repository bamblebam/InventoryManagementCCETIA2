package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryModel {
    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String description;

    @Field
    private String email;

    @CreatedDate
    private String createdDate;

    @Field
    private List<String> inventoryItems = new ArrayList<>();

    public InventoryModel(String name, String description, String email) {
        this.name = name;
        this.description = description;
        this.email = email;
    }

    @Override
    public String toString() {
        return "InventoryModel [description=" + description + ", email=" + email + ", id=" + id + ", name=" + name
                + "]";
    }

    // public void addInventoryItem(String inventoryItemId) {
    // getInventoryItems().add(inventoryItemId);
    // }

}
