package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.models.Products;

import java.util.List;

public interface ProductsDAO {
    public void add(Products product);
    public List<Products> getAll();
    public List<Products> getByProductId(int productId);
    public List<Products> getGetByName(String name);
    public List<Products> getGetGetByCategory(String category);
    public void delete(int productId);
    public void update(Products product);

    List<Products> getByProductId();

    List<Products> getGetByName();

    List<Products> getGetGetByCategory();
}
