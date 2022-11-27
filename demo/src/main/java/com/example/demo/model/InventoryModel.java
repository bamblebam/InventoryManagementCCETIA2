package com.example.demo.model;

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

}
