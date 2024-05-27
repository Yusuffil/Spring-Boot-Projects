package com.example.RealEstate.business.abstracts;

import com.example.RealEstate.business.requests.CreateProductRequests;
import com.example.RealEstate.business.responses.GetAllCategoryResponses;
import com.example.RealEstate.business.responses.GetAllProductResponses;

import java.util.List;

public interface ProductService {

    List<GetAllProductResponses> getAll();

    void add(CreateProductRequests createProductRequests);
}
