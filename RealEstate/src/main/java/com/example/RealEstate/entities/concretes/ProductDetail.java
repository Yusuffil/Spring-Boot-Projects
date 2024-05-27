package com.example.RealEstate.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="productdetails")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id ;

    @Column(name="size")
    private int size;

    @Column(name="bedroom_count")
    private int bedroomCount;

    @Column(name="bath_count")
    private int bath;

    @Column(name="room_count")
    private int roomCount;

    @OneToOne(mappedBy = "productDetail")
    private Product product;

    @Column(name="garageSize")
    private int garageSize;

    @Column(name="build_year")
    private int buildYear;

    @Column(name="price")
    private int price;

    @Column(name="location")
    private int location;

    @Column(name="videourl")
    private int videoUrl;

    @Column(name="comment")
    private int comment;


}
