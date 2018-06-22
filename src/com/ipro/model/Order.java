package com.ipro.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents the request of customer to be delivered specific products by a store
 */
public class Order {

    private String id;
    private String customerId;
    private String storeId;
    private ArrayList<Article> article;
    private ArrayList<Bundle> bundle;
    private Date date;

    public Order(String customerId, String storeId, ArrayList<Article> article, ArrayList<Bundle> bundle, Date date) {
        this.customerId = customerId;
        this.storeId = storeId;
        this.article = article;
        this.bundle = bundle;
        this.date = date;
    }
}
