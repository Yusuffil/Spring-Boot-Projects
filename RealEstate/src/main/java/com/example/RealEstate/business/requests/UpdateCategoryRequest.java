package com.example.RealEstate.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCategoryRequest {

    private int id;

    private String name;

    private boolean status;
}
