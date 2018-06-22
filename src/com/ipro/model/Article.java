package com.ipro.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * A type of product
 */
public class Article {
    private static ArrayList<String> columnNames = new ArrayList<String>() {{
        add("Id");
        add("Name");
        add("Brand");
        add("Pricetag");
        add("FacturingCost");
    }};

    private String id;
    private String name;
    private String brand;
    private double pricetag;
    private double facturingCost;

    public Article(String name, String brand, double pricetag, double facturingCost) {
        this.name = name;
        this.brand = brand;
        this.pricetag = pricetag;
        this.facturingCost = facturingCost;
    }

    /**
     * Returns all articles
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Article> findAllArticle() throws FileNotFoundException {
        ArrayList<Article> articleList = new ArrayList<Article>();
        String name;
        String brand;
        double pricetag;
        double facturingCost;

        for (String[] arrayData : FileManager.load("article", columnNames)) {
            name = arrayData[1];
            brand = arrayData[2];
            pricetag = Double.parseDouble(arrayData[3]);
            facturingCost = Double.parseDouble(arrayData[4]);
            Article article = new Article(name, brand, pricetag, facturingCost);
            articleList.add(article);
        }
        return articleList;
    }

    /**
     * Return article matching id
     * @return
     * @throws FileNotFoundException
     */
    public static Article findById(String id) throws FileNotFoundException {
        Article article;
        String name;
        String brand;
        double pricetag;
        double facturingCost;

        for (String[] arrayData : FileManager.load("article", columnNames)) {
            if (arrayData[0] == id) {
                name = arrayData[1];
                brand = arrayData[2];
                pricetag = Double.parseDouble(arrayData[3]);
                facturingCost = Double.parseDouble(arrayData[4]);
                article = new Article(name, brand, pricetag, facturingCost);
                return article;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPricetag() {
        return pricetag;
    }

    public double getFacturingCost() {
        return facturingCost;
    }
}
