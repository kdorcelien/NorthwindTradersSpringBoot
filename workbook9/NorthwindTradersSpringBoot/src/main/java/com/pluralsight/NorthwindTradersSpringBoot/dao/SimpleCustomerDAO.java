package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

@Component //bean
public class SimpleCustomerDAO implements CustomerDAO {
    private final DataSource dataSource;
    private List<Customer> customers;

    @Autowired
    public SimpleCustomerDAO(DataSource dataSource) {
        this.customers = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Customer> getAll() {
        this.customers.clear();
        String sql = "SELECT * FROM Customers;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.customers.add(new Customer(rows.getString(1), rows.getString(2), rows.getString(3),rows.getString(4), rows.getString(5),
                        rows.getString(6),rows.getString(7),rows.getString(8),rows.getString(9), rows.getString(10),rows.getString(11)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.customers;
    }

    @Override
    public List<Customer> getByCompanyName() {
        return null;
    }

    @Override
    public List<Customer> getByContactName() {
        return null;
    }

    @Override
    public List<Customer> getByAddress() {
        return null;
    }

    @Override
    public Customer getByCustomerID() {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public void add(Customer customer) {
        this.customers.add(customer);
    }
}