package com.example.RealEstate.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(max = 50)
    private String name;

    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;


}
