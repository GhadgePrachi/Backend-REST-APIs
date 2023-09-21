package com.project.inventorymanagement.data.solr;

import com.project.inventorymanagement.clients.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ProductDocumentRepository {
    @Autowired
    SolrClient solrClient;


    private static final SolrQuery.ORDER DEFAULT_SORT_ORDER = SolrQuery.ORDER.asc;
    private static final String DEFAULT_SORT_FIELD = "sku_id";
    private static final int DEFAULT_LIMIT = 10;

    public void save(ProductDocument product) throws SolrServerException, IOException {
        solrClient.getSolrClient().addBean(product);
        solrClient.getSolrClient().commit();
    }

    public void saveAll(List<ProductDocument> products) throws SolrServerException, IOException {
        solrClient.getSolrClient().addBeans(products);
        solrClient.getSolrClient().commit();
    }

    public List<ProductDocument> search(String fieldName, String fieldValue) throws SolrServerException, IOException {
        // constructs a SolrQuery instance
        String query = String.format("%s:%s", fieldName, fieldValue);
        final SolrQuery solrQuery = new SolrQuery(query);
        solrQuery.setSort(DEFAULT_SORT_FIELD, DEFAULT_SORT_ORDER);
        solrQuery.setRows(DEFAULT_LIMIT);

        // sends search request and gets the response
        QueryResponse response = solrClient.getSolrClient().query(solrQuery);

        // converts to domain objects and prints to standard output
        List<ProductDocument> productDocuments = response.getBeans(ProductDocument.class);
        return productDocuments;
    }
}
