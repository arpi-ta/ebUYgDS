package com.buy.eBuyGds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    @Id
    private Long id;
    private String name;
    private String description;
    private int price;
    private String seller;
    private String location;
    private LocalDate bestBefore;
    private String ingredients;
    private String healthWarning;
    private String warranty;
    private String serviceLocation;
    private String categoryType;


}
