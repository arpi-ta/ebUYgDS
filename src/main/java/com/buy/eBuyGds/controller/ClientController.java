package com.buy.eBuyGds.controller;

import com.buy.eBuyGds.model.Bill;
import com.buy.eBuyGds.model.Goods;
import com.buy.eBuyGds.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<Object> getAllProducts(){
        List<Goods> products= clientService.getAllProducts();
        if(products.isEmpty())
            return new ResponseEntity(products, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(products,HttpStatus.OK);

    }

    @GetMapping("/getAllProductsByCategory")
    public ResponseEntity<Object> getAllProductsByCategory(@RequestParam(name="category") String category){
        List<Goods> products= clientService.getAllProductsByCategory(category);
        if(products.isEmpty())
            return new ResponseEntity("there is no such category present", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(products,HttpStatus.OK);

    }

    @GetMapping("/checkout")
    public ResponseEntity<Object> getBill(@RequestParam(name="ids", required = true) List<Long> ids, @RequestParam(name="location", required = true) String location){
      Bill b= clientService.getValue(ids,location);
      if(b==null)
          return new ResponseEntity<>("no ids matched",HttpStatus.BAD_REQUEST);
      else
          return new ResponseEntity<>(b,HttpStatus.OK);
    }
}
