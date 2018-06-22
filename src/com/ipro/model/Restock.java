package com.ipro.model;

import java.util.Date;

/**
 * product at disposal
 */
public class Restock {

    private String id;
    private String storeId;
    private Article article;
    private int value;
    private Date date;

    public Restock(String storeId, Article article, int value, Date date) {
        this.storeId = storeId;
        this.article = article;
        this.value = value;
        this.date = date;
    }
}
