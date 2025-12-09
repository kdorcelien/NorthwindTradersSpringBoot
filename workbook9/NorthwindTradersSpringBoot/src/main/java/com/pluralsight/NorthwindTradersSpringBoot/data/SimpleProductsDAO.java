package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Products;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductsDAO implements ProductsDAO{
    private List<Products> products;

    public SimpleProductsDAO(){
        this.products = new ArrayList<>();
        this.products.add(new Products(01,"Steak","meat", 65.79));
        this.products.add(new Products(02, "Salmon", "seafood", 48.25));
        this.products.add(new Products(03, "Chicken Breast", "meat", 23.49));
        this.products.add(new Products(04, "Broccoli", "vegetable", 4.99));

    }


    @Override
    public void add(Products product) {
        this.products.add(product);

    }

    @Override
    public List<Products> getAll() {
        return this.products;
    }

    @Override
    public List<Products> getByProductId(int productId) {
        for (Products product : this.products) {
            if (product.getProductId() == productId) {
                return products;
            }
        }
        return null;
    }

    @Override
    public List<Products> getGetByName(String name) {
        return List.of();
    }

    @Override
    public List<Products> getGetGetByCategory(String category) {
        return List.of();
    }

    @Override
    public void delete(int productId) {

    }

    @Override
    public void update(Products product) {

    }

    @Override
    public List<Products> getByProductId() {
        return List.of();
    }

    @Override
    public List<Products> getGetByName() {
        return List.of();
    }

    @Override
    public List<Products> getGetGetByCategory() {
        return List.of();
    }
}
