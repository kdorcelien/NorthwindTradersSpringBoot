package com.pluralsight.NorthwindTradersAPI.controller;

import com.pluralsight.NorthwindTradersAPI.dao.ProductsDAO;
import com.pluralsight.NorthwindTradersAPI.model.Products;
import com.pluralsight.NorthwindTradersAPI.util.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    private final ProductsDAO productsDAO;

    @Autowired
    public ProductsController(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public List<Products> getAllProducts(){
        return this.productsDAO.getAll();
    }

    @RequestMapping(path="/products/{id}", method = RequestMethod.GET)
    public List<Products> getProductsById(@PathVariable int id){

        return this.productsDAO.getByProductId(id);
    }
}
