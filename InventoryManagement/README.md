# PROJECT NAME -
Inventory Management System

# DETAILED DESIGN DOCUMENT -
Google Doc - Design Documentation - Inventory Management System

# API SUPPORTED -
1. Load Inventory - Accepts the inventory file path, processes and load the data in mysql database.
2. Transform Inventory - Accepts an inventory id and transforms the data and stores in solr document store.
3. Search Inventory - Accepts the field name and value, searches the document store and returns the result.

# Data Stores SUPPORTED -
1. MySQL Database
 Product Table
2. Solr Document store
Product Document Store

# Misc Notes
## Challenges faced -
1. Spring Data Solr is deprecated - This lead to Apache Solrj for integrating with Apache Solr. Researching around this was a challenge.
2. File content - Lot of fields are missing, not in the right format so introduced the logic to ignore them to continue processing. 

## How to run MySQL locally ?
1. Download the official MySQL image from Docker hub.
2. Run it using - docker run --name some-mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=<your_password> mysql
3. Use the mysql CLI for querying.

## How to run Apache Solr locally ?
1. Download the official Apache Solr image from Docker hub.
2. Run it using - docker run --name some-solr -p 8983:8983 -d solr
3. Use the Solr UI for verification - http://localhost:8983

## How to partition files locally ?
1. Select and copy the first line with all columns to a new file -
   e.g. - head -1 Product_feed.tsv > Product_feed_200.tsv
2. Select and copy range of lines and append to the above file -
   e.g. - sed -n '200,300p' Product_feed.tsv >> Product_feed_200.tsv

## Future Enhancements - 
1. Support multiple fields for query filtering - 
   Add more query params, good to limit to a certain number.
2. Support query result fields to be passed - 
   e.g. - localhost:8080/search-inventory?fieldName=size&fieldValue=*SMALL&fields=sku_id,color,color_family
   In the above fields can be parsed as a list and then used to update to the SolrQuery with addFields().
3. Support pagination - 
   Use the start and rows options that Apache Solr provides.

