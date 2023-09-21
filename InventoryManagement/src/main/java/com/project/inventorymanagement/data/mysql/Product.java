package com.project.inventorymanagement.data.mysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product", schema = "demo")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "sku_id")
    Long skuId;
    @Column(name = "image")
    String image;
    @Column(name = "inventory_id")
    String inventoryId;
    @Column(name = "additional_image_link")
    String additionalImageLink;
    @Column(name = "style_id")
    Integer styleId;
    @Column(name = "class_id")
    Integer classId;
    String color;
    Integer colorCode;
    String colorFamily;
    String size;
    Integer sizeId;
    Integer departmentId;
    Integer dissectionCode;
    Boolean hazmat;
    String redline;
    Boolean promoted;
    String taxCode;
    String vendor;

    @Column(precision = 10, scale = 2)
    BigDecimal listPrice;

    @Column(precision = 10, scale = 2)
    BigDecimal salePrice;
    LocalDateTime salePriceEffectiveDate;
    String currency;
    Boolean shoprunnerEligible;
    String title;
    String link;
    String prodDescription;
    LocalDateTime startDate;
    String featuredColor;
    Boolean featuredColorCategory;
    String relatedProducts;
    Boolean preorder;
    @Column(name = "handling_code")
    String handlingCode;
    String video;
    String proportion;
    String proportionProducts;
    String masterStyle;
    Boolean cannotReturn;
    Boolean greatFind;
    Boolean webExclusive;
    Boolean nyDeals;
    String promoTagline;
    Boolean partiallyPromoted;
    String productCategory;
    String sortOrder;
    Integer quantitySold;
    @Column(precision = 4, scale = 2)
    BigDecimal averageRating;
}
