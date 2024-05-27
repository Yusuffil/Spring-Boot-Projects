package com.example.RealEstate.business.abstracts;

import com.example.RealEstate.business.requests.CreateCategoryRequest;
import com.example.RealEstate.business.requests.UpdateCategoryRequest;
import com.example.RealEstate.business.responses.CreateCategoryResponse;
import com.example.RealEstate.business.responses.GetAllCategoryResponses;
import com.example.RealEstate.business.responses.GetByCategoryIdResponse;
import com.example.RealEstate.core.utilities.exceptions.BusinessException;

import java.util.List;

public interface CategoryService {

    List<GetAllCategoryResponses> getAll();
    CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) throws BusinessException;

    boolean delete(int id);

    GetByCategoryIdResponse getById(int id);

    void update(UpdateCategoryRequest updateCategoryRequest);

}
