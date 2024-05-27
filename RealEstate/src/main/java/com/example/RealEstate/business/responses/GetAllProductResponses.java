package com.example.RealEstate.business.responses;

import com.example.RealEstate.entities.concretes.Category;
import com.example.RealEstate.entities.concretes.Employee;
import com.example.RealEstate.entities.concretes.ProductDetail;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponses {

    private int id;

    private String title;

    private int price;

    private String coverImage;

    private String city;

    private String district;

    private String address;

    private String description;

    private String categoryName;

    private String employeeName;

}
