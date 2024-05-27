package com.example.RealEstate.business.requests;

import com.example.RealEstate.entities.concretes.Category;
import com.example.RealEstate.entities.concretes.Employee;
import com.example.RealEstate.entities.concretes.ProductDetail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateProductRequests {

    @NotNull
        @Size(min=1, max=100)
    private String title;

    @NotNull
    private int price;

   /* @NotNull
    @NotBlank
    @Size(min=1, max=250)
    private String coverImage;
    */
    @NotNull
    @NotBlank
    @Size(min=1, max=100)
    private String city;

    @NotNull
    @NotBlank
    @Size(min=1, max=100)
    private String district;


    @NotNull
    private int categoryId;


}
