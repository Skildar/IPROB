package com.ipro.model;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * product at disposal
 */
public class Restock {
    private static ArrayList<String> columnNames = new ArrayList<String>() {{
        add("Id");
        add("storeId");
        add("articleId");
        add("value");
        add("date");
    }};

    private String id;
    private String storeId;
    private String articleId;
    private Integer value;
    private Date date;

    public Restock(String storeId, String articleId, Integer value, Date date) {
        this.storeId = storeId;
        this.articleId = articleId;
        this.value = value;
        this.date = date;
    }

    /**
     * Returns all restocks
     * @return
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static ArrayList<Restock> findAllRestock() throws FileNotFoundException, ParseException {
        ArrayList<Restock> restockList = new ArrayList<Restock>();

        for (String[] arrayData : FileManager.load("restock", columnNames)) {
            DateFormat format = new SimpleDateFormat("d MMMM, yyyy", Locale.FRANCE);

            String storeId = arrayData[1];
            String articleId = arrayData[2];
            Integer value = Integer.parseInt(arrayData[3]);
            Date date = format.parse(arrayData[4]);

            Restock restock = new Restock(storeId, articleId, value, date);
            restockList.add(restock);
        }
        return restockList;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getArticleId() {
        return articleId;
    }

    public int getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }
}
