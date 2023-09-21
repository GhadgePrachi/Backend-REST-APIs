package com.project.inventorymanagement.services;

import com.project.inventorymanagement.data.mysql.Product;
import com.project.inventorymanagement.data.solr.ProductDocument;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InventoryDocumentUtils {

    static List<ProductDocument> getProductDocuments(List<Product> products) {
        List<ProductDocument> productDocuments = new ArrayList<>();
        for (Product product : products) {
            ProductDocument productDocument = ProductDocument.builder()
                    .skuId(product.getSkuId())
                    .image(product.getImage())
                    .styleId(product.getStyleId())
                    .additionalImageLink(product.getAdditionalImageLink())
                    .inventoryId(product.getInventoryId())
                    .classId(product.getClassId())
                    .color(product.getColor())
                    .colorCode(product.getColorCode())
                    .colorFamily(product.getColorFamily())
                    .size(product.getSize())
                    .departmentId(product.getDepartmentId())
                    .dissectionCode(product.getDissectionCode())
                    .hazmat(product.getHazmat())
                    .redline(product.getRedline())
                    .promoted(product.getPromoted())
                    .taxCode(product.getTaxCode())
                    .vendor(product.getVendor())
                    .listPrice(getDoubleValue(product.getListPrice()))
                    .salePrice(getDoubleValue(product.getSalePrice()))
                    .salePriceEffectiveDate(getDateValue(product.getSalePriceEffectiveDate()))
                    .currency(product.getCurrency())
                    .shoprunnerEligible(product.getShoprunnerEligible())
                    .title(product.getTitle())
                    .link(product.getLink())
                    .prodDescription(product.getProdDescription())
                    .startDate(getDateValue(product.getStartDate()))
                    .featuredColor(product.getFeaturedColor())
                    .featuredColorCategory(product.getFeaturedColorCategory())
                    .relatedProducts(product.getRelatedProducts())
                    .preorder(product.getPreorder())
                    .handlingCode(product.getHandlingCode())
                    .video(product.getVideo())
                    .proportion(product.getProportion())
                    .proportionProducts(product.getProportionProducts())
                    .masterStyle(product.getMasterStyle())
                    .cannotReturn(product.getCannotReturn())
                    .greatFind(product.getGreatFind())
                    .webExclusive(product.getWebExclusive())
                    .nyDeals(product.getNyDeals())
                    .promoTagline(product.getPromoTagline())
                    .partiallyPromoted(product.getPartiallyPromoted())
                    .productCategory(product.getProductCategory())
                    .sortOrder(product.getSortOrder())
                    .quantitySold(product.getQuantitySold())
                    .averageRating(getDoubleValue(product.getAverageRating()))
                    .build();
            productDocuments.add(productDocument);
        }
        return productDocuments;
    }

    static String getDateValue(LocalDateTime dateTime) {
        if (dateTime != null) {
            return dateTime.toString();
        } else {
            return "";
        }
    }

    static Double getDoubleValue(BigDecimal number) {
        if (number != null) {
            return number.doubleValue();
        } else {
            return 0.0d;
        }

    }
}
