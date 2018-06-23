package com.ipro.model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Collection of a single type of article
 */
public class Bundle {
    private static ArrayList<String> columnNames = new ArrayList<String>() {{
        add("Id");
        add("articleId");
        add("reduction");
    }};

    private String id;
    private ArrayList<Article> article;
    private float reduction;

    public Bundle(ArrayList<Article> article, float reduction) {
        this.article = article;
        this.reduction = reduction;
    }

    /**
     * Returns all bundles
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Bundle> findAllBundle() throws FileNotFoundException {
        ArrayList<Bundle> bundleList = new ArrayList<Bundle>();
        ArrayList<Article> article;
        Float reduction;

        for (String[] arrayData : FileManager.load("bundle", columnNames)) {
            article = new ArrayList<Article>();
            String[] articleList = arrayData[1].split(",");
            for (String s: articleList) {
                Article temp = Article.findById(s);
                if (temp != null) {
                    article.add(temp);
                }
            }
            reduction = Float.parseFloat(arrayData[2]);
            Bundle bundle = new Bundle(article, reduction);
            bundleList.add(bundle);
        }
        return bundleList;
    }

    public ArrayList<Article> getArticle() {
        return article;
    }

    public float getReduction() {
        return reduction;
    }
}
