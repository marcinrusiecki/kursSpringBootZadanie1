package com.praca.domowa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Profile("START")
public class ShopStart{

    @Value("${word}")
    public String currency;

    ShopService shopService;

    @Autowired
    public ShopStart(ShopService shopService) {
        this.shopService = shopService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getSumAndList(){
        List<Shop> articles = shopService.createListOfArticles();
        shopService.printArticles(articles);
        Float sumStart = shopService.sumArticles(articles);
        System.out.println("Total sum: " + sumStart + currency);
    }




}
