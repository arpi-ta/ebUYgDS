package com.buy.eBuyGds;

import com.buy.eBuyGds.model.Goods;
import com.buy.eBuyGds.service.AdminService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

   @Test
    public void updateGoodsTest(){

        Goods good = new Goods();
        good.setId(5L);
        good.setBestBefore(LocalDate.of(2021,12,21));
        good.setDescription("gfgf");
        good.setHealthWarning("excellent");
        good.setLocation("Pune");
        good.setPrice(50);
        good.setSeller("tete");
        good.setName("Aez");
        good.setCategoryType("NonPeri");
        System.out.println(good);

         //Assert.assertTrue(adminService.updateGoods(good).equalsIgnoreCase("modified"));
       Assertions.assertEquals(adminService.updateGoods(good),"modified");
    }

    @Test
    public void test(){
       Assertions.assertEquals(1,1);
    }
}
