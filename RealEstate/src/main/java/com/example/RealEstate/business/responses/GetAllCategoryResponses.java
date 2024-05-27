package com.example.RealEstate.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoryResponses {

    private int id;

    private String name;

    private boolean status;
}
