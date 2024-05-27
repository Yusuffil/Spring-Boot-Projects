package com.example.RealEstate.entities.concretes;



import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    @Size(min=1, max=100)
    private String title;

    @Column(name="price")
    private int price;

    @Column(name="cover_image")
    @Size(min=1, max=250)
    private String coverImage;

    @Column(name="city")
    @Size(min=1, max=100)
    private String city;

    @Column(name="district")
    @Size(min=1, max=100)
    private String district;

    @Column(name="address")
    @Size(min=1, max=500)
    private String address;

    @Column(name="description")
    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Employee employee;

    @OneToOne
    private ProductDetail productDetail;

}
