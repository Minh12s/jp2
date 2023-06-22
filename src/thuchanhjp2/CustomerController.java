package thuchanhjp2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerController {
    private Map<String, Customer> cusMap;
    private Scanner scanner;

    public CustomerController() {
        cusMap = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            System.out.println("------ CRM ------");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    displayAll();
                    break;
                case 4:
                    System.out.println("Exit program");
                    break;
                default:
                    System.out.println("Error!Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    private void addCustomer() {
        System.out.println("------ Add New Customer ------");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(name, email, phone);
        cusMap.put(name, customer);
        System.out.println("Customer added successfully!");
    }

    private void findByName() {
        System.out.println("------ Find by name ------");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Customer customer = cusMap.get(name);
        if (customer != null) {
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
        } else {
            System.out.println("Not found.");
        }
    }

    private void displayAll() {
        System.out.println("------ Display all ------");
        if (cusMap.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : cusMap.values()) {
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Phone: " + customer.getPhone());
                System.out.println("--------------------");
            }
        }
    }
}