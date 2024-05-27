package com.example.RealEstate.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name="title")
    private String title;

    @NotNull
    @NotBlank
    @Column(name="phone_number")
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Column(name="mail_adress")
    private String mail;

    @NotNull
    @NotBlank
    @Column(name="status")
    private boolean status;

    @NotNull
    @NotBlank
    @Column(name="image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "employee")
    private List<Product> product;

}
