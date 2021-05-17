package com.buy.eBuyGds.service;

import com.buy.eBuyGds.model.Bill;
import com.buy.eBuyGds.model.Goods;
import com.buy.eBuyGds.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Goods> getAllProducts(){
        Iterable<Goods> product = clientRepository.findAll();
        List<Goods> products = new ArrayList<>();
        product.forEach(products::add);
        return products;
    }

    public List<Goods> getAllProductsByCategory(String category){
        Iterable<Goods> product = clientRepository.findGoodsByCategoryType(category);
        List<Goods> products = new ArrayList<>();
        product.forEach(products::add);
        return products;
    }

    public Bill getValue(List<Long> ids , String location){
        int totalPrice=0,deliveryTime=0,c=0;
        String productLocation;
        Bill b=  new Bill();
        for(long i:ids) {
            Optional<Goods> good = clientRepository.findById(i);
            Goods product = null;
            if (good.isPresent())
                product = good.get();

            totalPrice += product.getPrice();
            productLocation = product.getLocation();
            if ((productLocation.equalsIgnoreCase(location)) && c!=1) {
                deliveryTime = deliveryTime+1;
                c = 1;
            } else if (((productLocation .equalsIgnoreCase("Bangalore") && location.equalsIgnoreCase("Pune")) || (productLocation.equalsIgnoreCase("Pune") && location.equalsIgnoreCase("Bangalore"))) && c!=2)  {
                deliveryTime += 2;
                c = 2;

            } else if (((productLocation.equalsIgnoreCase("Mumbai") && location.equalsIgnoreCase("Bangalore")) || (productLocation.equalsIgnoreCase("Bangalore") && location.equalsIgnoreCase("Mumbai"))) && c!=3){
                deliveryTime += 3;
                c = 3;
            } else if (((productLocation.equalsIgnoreCase("Mumbai") && location.equalsIgnoreCase( "Pune")) || (productLocation .equalsIgnoreCase("Pune") && location.equalsIgnoreCase("Mumbai"))) && c!=4){
                deliveryTime++;
                c = 4;
            }
        }

        b.setDays(deliveryTime);
        b.setPrice(totalPrice);
        return b;
        }

}
