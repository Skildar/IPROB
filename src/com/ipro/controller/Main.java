package com.ipro.controller;

import com.ipro.model.*;

import java.io.FileNotFoundException;

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
        print();
    }

    /**
     * Based on the data objects and the filters, render a new list
     * Store --> id or name
     * Restock --> storeId
     * Order --> storeId
     */
    public static void print() throws FileNotFoundException {
        /**
         * TODO use a generic function to check every line
         */
        for (Article article : Article.findAllArticle()) {
            System.out.println(article.getName());
        }
        for (Store store : Store.findAllStore()) {
            System.out.println(store.getName());
        }
        for (Customer customer : Customer.findAllCustomer()) {
            System.out.println(customer.getFirstName() + " " + customer.getFamilyName());
        }
        for (Bundle bundle : Bundle.findAllBundle()) {
            System.out.println(bundle.getReduction());
        }
    }
}
