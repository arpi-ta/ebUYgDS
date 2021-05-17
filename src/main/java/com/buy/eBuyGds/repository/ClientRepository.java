package com.buy.eBuyGds.repository;

import com.buy.eBuyGds.model.Goods;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<Goods,Long> {
    @Query(value = "select * from Goods where Id=:Id", nativeQuery = true)
    List<Goods> findGoodsById(@Param("Id") UUID Id);

    @Query(value = "select * from Goods where CATEGORY_TYPE=:categoryType", nativeQuery = true)
    List<Goods> findGoodsByCategoryType(@Param("categoryType") String categoryType);

    @Query(value = "select * from Goods where name=:name", nativeQuery = true)
    List<Goods> findGoodsByName(@Param("name") String name);
}
