package com.example.RealEstate.entities.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "comment")
    @Size(max=2000)
    private String comment;
}
