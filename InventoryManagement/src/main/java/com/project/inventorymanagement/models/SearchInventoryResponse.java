package com.project.inventorymanagement.models;

import com.project.inventorymanagement.data.solr.ProductDocument;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SearchInventoryResponse {

    List<ProductDocument> results;
}
