package com.example.RealEstate.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCategoryIdResponse {

    private int id;

    private String name;
}
