package com.buy.eBuyGds.repository;

import com.buy.eBuyGds.model.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdminRepository extends CrudRepository<Goods, Long> {

}
