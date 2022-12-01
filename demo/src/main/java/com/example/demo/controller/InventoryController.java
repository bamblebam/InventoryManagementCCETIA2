package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InventoryItemModel;
import com.example.demo.model.InventoryModel;
import com.example.demo.repository.InventoryRepository;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @GetMapping("/all")
    public List<InventoryModel> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @GetMapping("/individual/{id}")
    public InventoryModel getIndividualInventory(@PathVariable String id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Inventory with id " + id + " does not exist"));
    }

    @PostMapping("/create")
    public InventoryModel createInventory(@RequestBody InventoryModel inventoryModel) {
        inventoryRepository.save(inventoryModel);
        return inventoryModel;
    }

    @PatchMapping("/addItem/{InventoryId}/{InventoryItemId}")
    public InventoryModel addItemToInventory(@PathVariable String InventoryId, @PathVariable String InventoryItemId) {
        InventoryModel inventoryModel = inventoryRepository.findById(InventoryId)
                .orElseThrow(() -> new IllegalStateException("Inventory with id " + InventoryId + " does not exist"));

        // List<String> items=inventoryModel.getInventoryItems();
        // inventoryModel.addInventoryItem(InventoryItemId);
        inventoryModel.getInventoryItems().add(InventoryItemId);

        inventoryRepository.save(inventoryModel);
        return inventoryModel;
    }
}
