package com.ipro.controller;

import com.ipro.model.*;
import com.ipro.view.App;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 *
 */
public class Main {
    private static FileManager fileManager = new FileManager();

    public static void main(String[] args) throws FileNotFoundException {

        try {
            print();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String activePanel = "Article";
        App test = new App();
    }


    /**
     * Using model classes, we create a list of objects relative to each type of data at disposal in respective .csv files.
     * Then print the content of each created object in the console.
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void print() throws FileNotFoundException, ParseException {
        System.out.println("-----  ----- Articles -----  -----");
        for (Article article : Article.findAllArticle()) {
            System.out.println(article.getName());
        }
        System.out.println("-----  ----- Stores -----  -----");
        for (Store store : Store.findAllStore()) {
            System.out.println(store.getName());
        }
        System.out.println("-----  ----- Customers -----  -----");
        for (Customer customer : Customer.findAllCustomer()) {
            System.out.println(customer.getFirstName() + " " + customer.getFamilyName());
        }
        System.out.println("-----  ----- Bundles -----  -----");
        for (Bundle bundle : Bundle.findAllBundle()) {
            System.out.println(bundle.getReduction());
        }
        System.out.println("-----  ----- Restocks -----  -----");
        for (Restock restock: Restock.findAllRestock()) {
            System.out.println(restock.getArticleId()
                    + ": "
                    + restock.getValue()
                    + " -- le "
                    + restock.getDate()
            );
        }
        System.out.println("-----  ----- Orders -----  -----");
        for (Order order : Order.findAllOrder()) {
            System.out.println(order.getCustomerId() + " -- le " + order.getDate());
            for (Article article : order.getArticle()) {
                System.out.println("- " + article.getName());
            }
        }

        System.out.println(FileManager.getNextId("article"));
    }
}
