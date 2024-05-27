package com.example.RealEstate.webApi.controllers;

import com.example.RealEstate.business.abstracts.ProductService;
import com.example.RealEstate.business.requests.CreateProductRequests;
import com.example.RealEstate.business.responses.GetAllProductResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsControllers {

    private ProductService productService;
    @GetMapping
    public List<GetAllProductResponses> getAll(){
        return this.productService.getAll();
    }

    @PostMapping
    public void add(@RequestBody @Valid CreateProductRequests createProductRequests){
        this.productService.add(createProductRequests);
    }
}
