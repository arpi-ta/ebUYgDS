package com.buy.eBuyGds.controller;

import com.buy.eBuyGds.model.Goods;
import com.buy.eBuyGds.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/updateProduct")
   public ResponseEntity updateProduct(@RequestBody Goods goods){
       String str= adminService.updateGoods(goods);
       if(str.equalsIgnoreCase("modified"))
           return new ResponseEntity("Your data has been modified",HttpStatus.OK);
       else
           return new ResponseEntity("Sorry retry again",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/deleteProduct")
    public ResponseEntity deleteProduct(@RequestParam Long id){
        String str= adminService.deleted(id);
        if(str.equalsIgnoreCase("deleted"))
            return new ResponseEntity("Your data has been deleted",HttpStatus.OK);
        else
            return new ResponseEntity("Sorry retry again Id not found",HttpStatus.BAD_REQUEST);
    }
}
