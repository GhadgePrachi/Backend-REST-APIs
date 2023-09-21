package com.project.inventorymanagement.clients;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.stereotype.Component;

@Component
public class SolrClient {
    public HttpSolrClient getSolrClient() {
        String solrDemoCoreUrl = "http://localhost:8983/solr/product";
        HttpSolrClient solrClient = new HttpSolrClient.Builder(solrDemoCoreUrl).build();
        solrClient.setParser(new XMLResponseParser());
        return solrClient;
    }
}
