package com.buy.eBuyGds.service;

import com.buy.eBuyGds.model.Goods;
import com.buy.eBuyGds.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public String updateGoods(Goods goods){

        adminRepository.save(goods);
        return "modified";
    }

    public String deleted(long id){
        Iterable<Goods> goods = adminRepository.findAll();
        List<Goods> products = new ArrayList<>();
        long deletedId;
        goods.forEach(products::add);
        for(Goods goods1:products){
            if(goods1.getId()==id)
                deletedId= id;
        }
        adminRepository.deleteById(id);
         return "deleted";
    }

    public String createNewProduct(Goods good){
        adminRepository.save(good);
        return "saved";
    }
}
