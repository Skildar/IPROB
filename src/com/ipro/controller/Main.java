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

        /**
         * Calls a function that starts the reading process.
         * It reads each .csv file and creates an object for every line found inside them (except header).
         *
         * Those objects are them stocked inside multiple ArrayList<>.
         * Which are returned to this Main class.
         *
         * The goal here is to have every information at disposal using the model classes.
         * Then we must display everything on the Graphic User Interface.
         *
         * Inputs, select list and buttons can be used to filter the information.
         * For example, when a specific store is selected, we must show only articles from that specific store!
         * As so, we need to have dedicated display variables that only contain this filtered information!
         */
        try {
            print();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String activePanel = "Article";
        App test = new App();
    }


    /**
     * Based on the data objects and the filters, render a new list
     * Store --> id or name
     * Restock --> storeId
     * Order --> storeId
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void print() throws FileNotFoundException, ParseException {
        /**
         * TODO use the graphic interface to display every information
         */
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
    }
}
