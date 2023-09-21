package com.project.inventorymanagement.services;

import com.project.inventorymanagement.data.mysql.Product;
import com.project.inventorymanagement.data.mysql.ProductRepository;
import com.project.inventorymanagement.data.solr.ProductDocument;
import com.project.inventorymanagement.data.solr.ProductDocumentRepository;
import com.project.inventorymanagement.models.LoadInventoryRequest;
import com.project.inventorymanagement.models.TransformInventoryRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
@Service
@Slf4j
public class InventoryService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDocumentRepository productDocumentRepository;

    public String readInventory(LoadInventoryRequest loadInventoryRequest) {
        String inventoryId = UUID.randomUUID().toString();
        String filePath = loadInventoryRequest.getFilePath();
        List<Product> products = InventoryDBUtils.ingestInventory(filePath, inventoryId);
        log.info("Total products saving to database : " + products.size());
        productRepository.saveAll(products);
        return inventoryId;
    }

    public void transformInventory(TransformInventoryRequest transformInventoryRequest) throws SolrServerException, IOException {
        String inventoryId = transformInventoryRequest.getInventoryId();
        List<Product> products = productRepository.findAllByInventoryId(inventoryId);
        List<ProductDocument> productDocuments = InventoryDocumentUtils.getProductDocuments(products);
        log.info("Total products saving to document store : " + productDocuments.size());
        productDocumentRepository.saveAll(productDocuments);
    }

    public List<ProductDocument> searchInventory(String fieldName, String fieldValue) throws SolrServerException, IOException {
        List<ProductDocument> productDocuments = productDocumentRepository.search(fieldName, fieldValue);
        return productDocuments;
    }
}
