package com.pluralsight.NorthwindTradersSpringBoot.cli;


import com.pluralsight.NorthwindTradersSpringBoot.dao.CustomerDAO;
import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductsDAO;
import com.pluralsight.NorthwindTradersSpringBoot.models.Customer;
import com.pluralsight.NorthwindTradersSpringBoot.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.pluralsight.NorthwindTradersSpringBoot.util.InputValidator;
import com.pluralsight.NorthwindTradersSpringBoot.util.ConsoleColors;


import java.util.Scanner;

@Component
public class NorthwindTradersCLI implements CommandLineRunner {

    private final Scanner scanner;
    private final ProductsDAO productDao;
    private final CustomerDAO customerDAO;

    @Autowired
    public NorthwindTradersCLI(ProductsDAO productDao, CustomerDAO customerDAO) {
        this.productDao = productDao;
        this.customerDAO = customerDAO;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        while(true) {
            System.out.println("1. List Products\n" +
                    "2. Add Product\n" +
                    "3. \tList Customer\n" +
                    "4. \tAdd Customer\n" +
                    "0. Exit");
            int option = InputValidator.getIntInRange("Enter option: ",1,4);

            switch (option) {
                case 1:
                    productDao.getAll().forEach(System.out::println);
                    InputValidator.clearScreen();
                    break;
                case 2:
                    System.out.print("Enter a product id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter a product name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Enter a category name: ");
                    String category = scanner.nextLine().trim();

                    System.out.print("Enter a price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    productDao.add(new Products(id, name, category, price));
                    ConsoleColors.printSuccess("New Product Added Successfully");
                    InputValidator.clearScreen();
                    break;
                case 3:
                    listCustomers();
                    break;
                case 4:
                    addCustomers();
                    break;
                case 0:
                default:
                    System.exit(0);
            }
        }
    }

    private void listCustomers(){
        ConsoleColors.printHeader("All Customers");
        customerDAO.getAll().forEach(System.out::println);
        InputValidator.clearScreen();
    }
    private void addCustomers(){
        String customerId = InputValidator.getString("Enter customerId : ");
        String companyName= InputValidator.getString("Enter companyName: ");
        String contactName= InputValidator.getString("Enter contactName: ");
        String contactTitle= InputValidator.getString("Enter contactTitle: ");
        String address= InputValidator.getString("Enter address: ");
        String city= InputValidator.getString("Enter city: ");
        String region= InputValidator.getString("Enter region: ");
        String postalCode= InputValidator.getString("Enter postalCode: ");
        String country= InputValidator.getString("Enter country: ");
        String phone= InputValidator.getString("Enter phone: ");
        String fax= InputValidator.getString("Enter fax: ");

        customerDAO.add(new Customer(customerId, companyName, contactName, contactTitle,
                address, city, region, postalCode, country, phone, fax));
        ConsoleColors.printSuccess("New Customer Added Successfully");
        InputValidator.clearScreen();
    }
}
