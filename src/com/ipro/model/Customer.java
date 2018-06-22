package com.ipro.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The entity purchasing products
 */
public class Customer {
    private static ArrayList<String> columnNames = new ArrayList<String>() {{
        add("Id");
        add("familyName");
        add("firstName");
        add("address");
    }};

    private String id;
    private String familyName;
    private String firstName;
    private String address;

    public Customer(String familyName, String firstName, String address) {
        this.familyName = familyName;
        this.firstName = firstName;
        this.address = address;
    }

    /**
     * Returns all customers
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Customer> findAllCustomer() throws FileNotFoundException {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        String familyName;
        String firstName;
        String address;

        for (String[] arrayData : FileManager.load("customer", columnNames)) {
            familyName = arrayData[1];
            firstName = arrayData[2];
            address = arrayData[3];
            Customer customer = new Customer(familyName, firstName, address);
            customerList.add(customer);
        }
        return customerList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getAddress() {
        return address;
    }
}
