package com.praca.domowa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("PLUS")

public class ShopPlus {

    @Value("${word}")
    public String currency;

    ShopService shopService;

    @Autowired
    public ShopPlus(ShopService shopService) {
        this.shopService = shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createListAndAddTaxToSum(){
        List<Shop> articles = shopService.createListOfArticles();
        shopService.printArticles(articles);
        Float sumWithoutTax = shopService.sumArticles(articles);
        Float sumWithTax = shopService.addTax(sumWithoutTax);
        System.out.println("Total sum without tax: " + sumWithoutTax + currency);
        System.out.println("Total sum with tax: " + sumWithTax + currency);
    }
}
