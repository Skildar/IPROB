package com.ipro.model;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Represents the request of customer to be delivered specific products by a store
 */
public class Order {
    private static ArrayList<String> columnNames = new ArrayList<String>() {{
        add("Id");
        add("customerId");
        add("storeId");
        add("articleId");
        add("date");
    }};

    private String id;
    private String customerId;
    private String storeId;
    private ArrayList<Article> article;
    private Date date;

    public Order(String customerId, String storeId, ArrayList<Article> article, Date date) {
        this.customerId = customerId;
        this.storeId = storeId;
        this.article = article;
        this.date = date;
    }

    /**
     * Returns all orders
     * @return
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static ArrayList<Order> findAllOrder() throws FileNotFoundException, ParseException {
        ArrayList<Order> orderList = new ArrayList<Order>();
        ArrayList<Article> article;

        for (String[] arrayData : FileManager.load("order", columnNames)) {
            article = new ArrayList<Article>();
            DateFormat format = new SimpleDateFormat("d MMMM, yyyy", Locale.FRANCE);

            String customerId = arrayData[1];
            String storeId = arrayData[2];
            String[] articleList = arrayData[3].split(",");
            for (String s: articleList) {
                article.add(Article.findById(s));
            }
            Date date = format.parse(arrayData[4]);

            Order order = new Order(customerId, storeId, article, date);
            orderList.add(order);
        }
        return orderList;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public ArrayList<Article> getArticle() {
        return article;
    }

    public Date getDate() {
        return date;
    }
}
