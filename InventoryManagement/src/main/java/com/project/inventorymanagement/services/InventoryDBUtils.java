package com.project.inventorymanagement.services;

import com.project.inventorymanagement.data.mysql.Product;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class InventoryDBUtils {
    public static final String TAB_DELIMITER = "\t";

    public static int TOTAL_FIELDS;

    public static List<Product> ingestInventory(String path, String inventoryId) {
        List<Product> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            boolean isFirstLine = true;
            while (scanner.hasNextLine()) {
                if(!isFirstLine) {
                    try {
                        records.add(getRecordFromLine(scanner.nextLine(),inventoryId));
                    } catch (Exception e) {
                        log.warn(e.getLocalizedMessage());
                    }
                } else {
                    isFirstLine = false;
                    String columns = scanner.nextLine();
                    TOTAL_FIELDS = columns.split(TAB_DELIMITER).length;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return records;
    }

    private static Product getRecordFromLine(String line, String inventoryId) {
        List<String> attributes = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(TAB_DELIMITER);
            while (rowScanner.hasNext()) {
                attributes.add(rowScanner.next());
            }
        }
        return buildProduct(attributes, inventoryId);
    }

    private static Product buildProduct(List<String> attributes, String inventoryId) {
        return Product.builder().
                inventoryId(inventoryId).
                skuId(Long.valueOf(attributes.get(0))).
                image(attributes.get(1)).
                additionalImageLink(attributes.get(2)).
                styleId(getInteger(attributes.get(3))).
                classId(getInteger(attributes.get(4))).
                color(attributes.get(5)).
                colorCode(getInteger(attributes.get(6))).
                colorFamily(attributes.get(7)).
                size(attributes.get(8)).
                sizeId(getInteger(attributes.get(9))).
                departmentId(getInteger(attributes.get(10))).
                dissectionCode(getInteger(attributes.get(11))).
                hazmat(Boolean.valueOf(attributes.get(12))).
                redline(attributes.get(13)).
                promoted(Boolean.valueOf(attributes.get(14))).
                taxCode(attributes.get(15)).
                vendor(attributes.get(16)).
                listPrice(getBigDecimal(attributes.get(17))).
                salePrice(getBigDecimal(attributes.get(18))).
                salePriceEffectiveDate(getDateTime(attributes.get(19))).
                currency(attributes.get(20)).
                shoprunnerEligible(Boolean.valueOf(attributes.get(21))).
                title(attributes.get(22)).
                link(attributes.get(23)).
                prodDescription(attributes.get(24)).
                startDate(getDateTime(attributes.get(25))).
                featuredColor(attributes.get(26)).
                featuredColorCategory(Boolean.valueOf(attributes.get(27))).
                relatedProducts(attributes.get(28)).
                preorder(Boolean.valueOf(attributes.get(29))).
                handlingCode(attributes.get(30)).
                video(attributes.get(31)).
                proportion(attributes.get(32)).
                proportionProducts(attributes.get(33)).
                masterStyle(attributes.get(34)).
                cannotReturn(Boolean.valueOf(attributes.get(35))).
                greatFind(Boolean.valueOf(attributes.get(36))).
                webExclusive(Boolean.valueOf(attributes.get(37))).
                nyDeals(Boolean.valueOf(attributes.get(38))).
                promoTagline(attributes.get(39)).
                partiallyPromoted(Boolean.valueOf(attributes.get(40))).
                productCategory(attributes.get(41)).
                sortOrder(attributes.get(42)).
                quantitySold(getInteger(attributes.get(43))).
                averageRating(getBigDecimal(attributes.get(44))).
                build();
    }

    private static Integer getInteger(String s) {
        if (s != null && s.length() > 0) {
            return Integer.valueOf(s);
        } else {
            return null;
        }
    }

    private static LocalDateTime getDateTime(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        if (s != null && s.length() > 0) {
            return LocalDateTime.parse(s, formatter);
        } else {
            return null;
        }
    }

    private static BigDecimal getBigDecimal(String s) {
        if (s != null && s.length() > 0) {
            return new BigDecimal(s);
        } else {
            return null;
        }
    }
}
