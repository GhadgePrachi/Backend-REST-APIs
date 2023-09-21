package com.project.inventorymanagement.data.solr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDocument {
    Long skuId;
    String image;
    String inventoryId;
    String additionalImageLink;
    Integer styleId;
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
    Double listPrice;
    Double salePrice;
    String salePriceEffectiveDate;
    String currency;
    Boolean shoprunnerEligible;
    String title;
    String link;
    String prodDescription;
    String startDate;
    String featuredColor;
    Boolean featuredColorCategory;
    String relatedProducts;
    Boolean preorder;
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
    Double averageRating;
    public Long getSkuId() {
        return skuId;
    }

    @Field("sku_id")
    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getImage() {
        return image;
    }

    @Field("image")
    public void setImage(String image) {
        this.image = image;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    @Field("inventory_id")
    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getAdditionalImageLink() {
        return additionalImageLink;
    }

    @Field("additional_image_link")
    public void setAdditionalImageLink(String additionalImageLink) {
        this.additionalImageLink = additionalImageLink;
    }

    public Integer getStyleId() {
        return styleId;
    }

    @Field("style_id")
    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getClassId() {
        return classId;
    }

    @Field("class_id")
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getColor() {
        return color;
    }

    @Field("color")
    public void setColor(String color) {
        this.color = color;
    }

    public Integer getColorCode() {
        return colorCode;
    }

    @Field("color_code")
    public void setColorCode(Integer colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorFamily() {
        return colorFamily;
    }

    @Field("color_family")
    public void setColorFamily(String colorFamily) {
        this.colorFamily = colorFamily;
    }

    public String getSize() {
        return size;
    }

    @Field("size")
    public void setSize(String size) {
        this.size = size;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    @Field("size_id")
    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    @Field("department_id")
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDissectionCode() {
        return dissectionCode;
    }

    @Field("dissection_code")
    public void setDissectionCode(Integer dissectionCode) {
        this.dissectionCode = dissectionCode;
    }

    public Boolean getHazmat() {
        return hazmat;
    }

    @Field("hazmat")
    public void setHazmat(Boolean hazmat) {
        this.hazmat = hazmat;
    }

    public String getRedline() {
        return redline;
    }

    @Field("redline")
    public void setRedline(String redline) {
        this.redline = redline;
    }

    public Boolean getPromoted() {
        return promoted;
    }

    @Field("promoted")
    public void setPromoted(Boolean promoted) {
        this.promoted = promoted;
    }

    public String getTaxCode() {
        return taxCode;
    }

    @Field("tax_code")
    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getVendor() {
        return vendor;
    }

    @Field("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getListPrice() {
        return listPrice;
    }

    @Field("list_price")
    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    @Field("sale_price")
    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getSalePriceEffectiveDate() {
        return salePriceEffectiveDate;
    }

    @Field("sale_price_effective_date")
    public void setSalePriceEffectiveDate(String salePriceEffectiveDate) {
        this.salePriceEffectiveDate = salePriceEffectiveDate;
    }

    public String getCurrency() {
        return currency;
    }

    @Field("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getShoprunnerEligible() {
        return shoprunnerEligible;
    }

    @Field("shoprunner_eligible")
    public void setShoprunnerEligible(Boolean shoprunnerEligible) {
        this.shoprunnerEligible = shoprunnerEligible;
    }

    public String getTitle() {
        return title;
    }

    @Field("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    @Field("link")
    public void setLink(String link) {
        this.link = link;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    @Field("prod_description")
    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    @Field("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFeaturedColor() {
        return featuredColor;
    }

    @Field("featured_color")
    public void setFeaturedColor(String featuredColor) {
        this.featuredColor = featuredColor;
    }

    public Boolean getFeaturedColorCategory() {
        return featuredColorCategory;
    }

    @Field("featured_color_category")
    public void setFeaturedColorCategory(Boolean featuredColorCategory) {
        this.featuredColorCategory = featuredColorCategory;
    }

    public String getRelatedProducts() {
        return relatedProducts;
    }

    @Field("related_products")
    public void setRelatedProducts(String relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public Boolean getPreorder() {
        return preorder;
    }

    @Field("preorder")
    public void setPreorder(Boolean preorder) {
        this.preorder = preorder;
    }

    public String getHandlingCode() {
        return handlingCode;
    }

    @Field("handling_code")
    public void setHandlingCode(String handlingCode) {
        this.handlingCode = handlingCode;
    }

    public String getVideo() {
        return video;
    }

    @Field("video")
    public void setVideo(String video) {
        this.video = video;
    }

    public String getProportion() {
        return proportion;
    }

    @Field("proportion")
    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getProportionProducts() {
        return proportionProducts;
    }

    @Field("proportion_products")
    public void setProportionProducts(String proportionProducts) {
        this.proportionProducts = proportionProducts;
    }

    public String getMasterStyle() {
        return masterStyle;
    }

    @Field("master_style")
    public void setMasterStyle(String masterStyle) {
        this.masterStyle = masterStyle;
    }

    public Boolean getCannotReturn() {
        return cannotReturn;
    }

    @Field("cannot_return")
    public void setCannotReturn(Boolean cannotReturn) {
        this.cannotReturn = cannotReturn;
    }

    public Boolean getGreatFind() {
        return greatFind;
    }

    @Field("great_find")
    public void setGreatFind(Boolean greatFind) {
        this.greatFind = greatFind;
    }

    public Boolean getWebExclusive() {
        return webExclusive;
    }

    @Field("web_exclusive")
    public void setWebExclusive(Boolean webExclusive) {
        this.webExclusive = webExclusive;
    }

    public Boolean getNyDeals() {
        return nyDeals;
    }

    @Field("ny_deals")
    public void setNyDeals(Boolean nyDeals) {
        this.nyDeals = nyDeals;
    }

    public String getPromoTagline() {
        return promoTagline;
    }

    @Field("promo_tagline")
    public void setPromoTagline(String promoTagline) {
        this.promoTagline = promoTagline;
    }

    public Boolean getPartiallyPromoted() {
        return partiallyPromoted;
    }

    @Field("partially_promoted")
    public void setPartiallyPromoted(Boolean partiallyPromoted) {
        this.partiallyPromoted = partiallyPromoted;
    }

    public String getProductCategory() {
        return productCategory;
    }

    @Field("product_category")
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    @Field("sort_order")
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    @Field("quantity_sold")
    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    @Field("average_rating")
    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
