package com.praca.domowa;

import java.util.List;

public interface ShopInt {

    void getInfo(String name, Float price);
    List<Shop> createListOfArticles();
    void addArticle(Shop shop);
    Float sumArticles(List<Shop> articles);
    void  printArticles(List<Shop> articles);
    Float addTax(Float sum);
    Float sumAfterDiscount(Float sum);

}
