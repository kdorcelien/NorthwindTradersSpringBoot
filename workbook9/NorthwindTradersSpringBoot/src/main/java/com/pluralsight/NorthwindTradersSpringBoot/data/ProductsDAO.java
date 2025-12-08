package com.pluralsight.NorthwindTradersSpringBoot.data;

import com.pluralsight.NorthwindTradersSpringBoot.models.Products;

import java.util.List;

public interface ProductsDAO {
    public void add(Products product);
    public List<Products> getAll();
    public List<Products> getByProductId();
    public List<Products> getGetByName();
    public List<Products> getGetGetByCategory();
    public void delete();

}
