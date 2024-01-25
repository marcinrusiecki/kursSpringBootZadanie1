package com.praca.domowa;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@ConfigurationProperties(prefix = "plus")
public class ShopService implements ShopInt{

    @Value("${word}")
    private String word;

    private int tax;
    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    @Override
    public void getInfo(String name, Float price) {
        System.out.println("Name of product: " + name + " Price: " + price + word);
    }

    @Override
    public List<Shop> createListOfArticles() {


        List<Shop> articles = new ArrayList<>();

        Shop article = new Shop("Window", (float) round());
        Shop article2 = new Shop("Door", (float) round());
        Shop article3 = new Shop("Lamp", (float) round());
        Shop article4 = new Shop("Chair", (float) round());
        Shop article5 = new Shop("Bed", (float) round());
        articles.add(article);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);

        return articles;
    }

    @Override
    public void addArticle(Shop shop) {
        System.out.println("Article has been added!");
    }

    public static double round() {
        Random random = new Random();
        Float randomPrice = random.nextFloat(50, 300);
        return Math.round(randomPrice * 100.0) / 100.0;
    }

    @Override
    public Float sumArticles(List<Shop> articles) {
        int sum = 0;
        for (int i = 0; i < articles.size(); i++) {

            sum += articles.get(i).getPrice();
        }
        return Float.valueOf(sum);
    }

    @Override
    public void printArticles(List<Shop> articles) {
        for (int i = 0; i < articles.size(); i++) {
            getInfo(articles.get(i).getName(), articles.get(i).getPrice());
        }
    }

    @Override
    public Float addTax(Float sum) {
        Float taxTemp = (sum * tax)/100;
        return sum + taxTemp;
    }

    @Override
    public Float sumAfterDiscount(Float sum) {
        Float discountTemp = (sum * discount)/100;
        return sum - discountTemp;
    }
}
