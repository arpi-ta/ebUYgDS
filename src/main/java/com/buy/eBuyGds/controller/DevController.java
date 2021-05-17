package com.buy.eBuyGds.controller;

import com.buy.eBuyGds.model.Goods;
import com.buy.eBuyGds.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class DevController {

    @Autowired
    AdminService adminService;

    @PostMapping("/addProduct")
    public ResponseEntity updateProduct(@RequestBody Goods good){
        String str= adminService.createNewProduct(good);
        if(str.equalsIgnoreCase("saved"))
            return new ResponseEntity("added new data", HttpStatus.OK);
        else
            return new ResponseEntity("Sorry retry again",HttpStatus.BAD_REQUEST);
    }
}
