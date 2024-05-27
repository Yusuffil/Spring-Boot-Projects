package com.example.RealEstate.webApi.controllers;


import com.example.RealEstate.business.abstracts.CategoryService;
import com.example.RealEstate.business.requests.CreateCategoryRequest;
import com.example.RealEstate.business.requests.UpdateCategoryRequest;
import com.example.RealEstate.business.responses.CreateCategoryResponse;
import com.example.RealEstate.business.responses.GetAllCategoryResponses;
import com.example.RealEstate.business.responses.GetByCategoryIdResponse;
import com.example.RealEstate.core.utilities.exceptions.BusinessException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesControllers {
    private CategoryService categoryService;
    @GetMapping
    public List<GetAllCategoryResponses> getAll(){
        return categoryService.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreateCategoryResponse add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) throws BusinessException {
        categoryService.add(createCategoryRequest);
        return new CreateCategoryResponse();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name="id") int categoryId){
        this.categoryService.delete(categoryId);
    }

    @PutMapping
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        this.categoryService.update(updateCategoryRequest);
    }

    @GetMapping("/{id}")
    public GetByCategoryIdResponse getById(@PathVariable(name="id") int id){
        return this.categoryService.getById(id);
    }


}
