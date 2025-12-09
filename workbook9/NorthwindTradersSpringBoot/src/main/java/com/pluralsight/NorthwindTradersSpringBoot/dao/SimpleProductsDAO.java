package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.models.Customer;
import com.pluralsight.NorthwindTradersSpringBoot.models.Products;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductsDAO implements ProductsDAO {
    private final DataSource dataSource;
    private List<Products> products;

    public SimpleProductsDAO(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }


    @Override
    public void add(Products product) {
        this.products.add(product);

    }

    @Override
    public List<Products> getAll() {
        this.products.clear();
        String query = "SELECT p.productId, p.ProductName, c.CategoryName, p.UnitPrice FROM Products p JOIN Categories c" +
                " ON P.CategoryID = C.CategoryID ";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rows = statement.executeQuery();
            while (rows.next()) {
                this.products.add(new Products(rows.getInt(1), rows.getString(2), rows.getString(3), rows.getInt(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public List<Products> getByProductId(int productId) {
//        List<Products> products =new ArrayList<>();
        String query = "SELECT * FROM Products WHERE productId = ?";

        try {
            Connection connection = dataSource.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setInt(1, productId);

                try (ResultSet rows = statement.executeQuery()) {
                    while (rows.next()) {
                        this.products.add(new Products(rows.getInt(1), rows.getString(2), rows.getString(3), rows.getInt(4)));
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.products;
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
