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
import com.example.demo.repository.InventoryItemRepository;

@RestController
@RequestMapping("/inventoryItem")
public class InventoryItemController {
    private final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public InventoryItemController(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @GetMapping("/all")
    public List<InventoryItemModel> getAllInventoryItems() {
        return inventoryItemRepository.findAll();
    }

    @GetMapping("/individual/{id}")
    public InventoryItemModel getIndividualInventoryItem(@PathVariable String id) {
        return inventoryItemRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("InventoryItem with id " + id + " does not exist"));
    }

    @PostMapping("/create")
    public InventoryItemModel createInventoryItem(@RequestBody InventoryItemModel inventoryItemModel) {
        inventoryItemRepository.save(inventoryItemModel);
        return inventoryItemModel;
    }

    @PatchMapping("/updateQuantity/{id}")
    public InventoryItemModel updateInventoryItemQuantity(@PathVariable String id,
            @RequestBody Map<String, Integer> quantity) {
        InventoryItemModel inventoryItemModel = inventoryItemRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("InventoryItem with id " + id + " does not exist"));

        inventoryItemModel.setQuantity(quantity.get("quantity"));
        inventoryItemRepository.save(inventoryItemModel);
        return inventoryItemModel;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInventoryItem(@PathVariable String id) {
        inventoryItemRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("InventoryItem with id " + id + " does not exist"));
        inventoryItemRepository.deleteById(id);
    }
}
