package com.ipro.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Entity that sells articles and packages to customers
 */
public class Store {
    private static ArrayList<String> columnNames = new ArrayList<String>() {{
        add("Id");
        add("Name");
        add("OperatingCost");
    }};

    private String id;
    private String name;
    private float operatingCost;

    public Store(String name, float operatingCost) {
        this.name = name;
        this.operatingCost = operatingCost;
    }

    /**
     * Returns all stores
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Store> findAllStore() throws FileNotFoundException {
        ArrayList<Store> storeList = new ArrayList<Store>();
        String name;
        float operatingCost;

        for (String[] arrayData : FileManager.load("store", columnNames)) {
            name = arrayData[1];
            operatingCost = Float.parseFloat(arrayData[2]);
            Store store = new Store(name, operatingCost);
            storeList.add(store);
        }
        return storeList;
    }

    public String getName() {
        return name;
    }

    public float getOperatingCost() {
        return operatingCost;
    }
}
