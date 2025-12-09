package com.pluralsight.NorthwindTradersSpringBoot.models;

import com.pluralsight.NorthwindTradersSpringBoot.util.ConsoleColors;
import com.pluralsight.NorthwindTradersSpringBoot.util.InputValidator;

public class Products {
    private int productId;
    private String name, category;
    private double price;

    public Products(int productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return ConsoleColors.PURPLE +  "Products: " +
                "\n\tproductId='" + productId + '\'' +
                "\n\tname='" + name + '\'' +
                "\n\tcategory='" + category + '\'' +
                "\n\tprice='" + price + '\'' + '\n';
    }
}
