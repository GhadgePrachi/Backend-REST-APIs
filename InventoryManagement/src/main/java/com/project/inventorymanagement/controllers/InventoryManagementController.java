package com.project.inventorymanagement.controllers;

import com.project.inventorymanagement.data.solr.ProductDocument;
import com.project.inventorymanagement.models.*;
import com.project.inventorymanagement.services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class InventoryManagementController {
    @Autowired
    InventoryService inventoryService;
    @RequestMapping(method = RequestMethod.GET, value = "/health")
    public ResponseEntity<?> health() {
        return ResponseEntity.ok("Status : Server is up and running!");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/load-inventory")
    public ResponseEntity<LoadInventoryResponse> loadInventory(@RequestBody LoadInventoryRequest inventoryRequest) {
        String inventoryId = inventoryService.readInventory(inventoryRequest);
        LoadInventoryResponse response = LoadInventoryResponse.builder().
                inventoryId(inventoryId).
                build();
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/transform-inventory")
    public ResponseEntity<TransformInventoryResponse> transformInventory(@RequestBody TransformInventoryRequest inventoryRequest) {
        try {
            inventoryService.transformInventory(inventoryRequest);
        } catch (SolrServerException | IOException e) {
            return ResponseEntity.internalServerError().build();
        }

        TransformInventoryResponse response = TransformInventoryResponse.builder()
                        .status("SUCCESS").build();
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search-inventory")
    public ResponseEntity<SearchInventoryResponse> transformInventory(@RequestParam(name = "fieldName") String fieldName, @RequestParam(name = "fieldValue") String fieldValue) {
        List<ProductDocument> productDocuments;
        try {
            productDocuments = inventoryService.searchInventory(fieldName, fieldValue);
        } catch (SolrServerException | IOException e) {
            return ResponseEntity.internalServerError().build();
        }
        SearchInventoryResponse response = SearchInventoryResponse.builder()
                        .results(productDocuments)
                        .build();
        return ResponseEntity.ok(response);
    }
}
