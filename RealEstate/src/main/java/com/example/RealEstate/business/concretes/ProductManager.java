package com.example.RealEstate.business.concretes;

import com.example.RealEstate.business.abstracts.ProductService;
import com.example.RealEstate.business.requests.CreateProductRequests;
import com.example.RealEstate.business.responses.GetAllProductResponses;
import com.example.RealEstate.core.utilities.mappers.ModelMapperService;
import com.example.RealEstate.dataAccess.abstracts.ProductRepository;
import com.example.RealEstate.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllProductResponses> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponses> getAllProductResponsesList = products.stream().
                map(product -> this.modelMapperService.forResponse().
                    map(product, GetAllProductResponses.class)).toList();
        return getAllProductResponsesList;
    }

    @Override
    public void add(CreateProductRequests createProductRequests) {
        var product = modelMapperService.forRequest().map(createProductRequests,Product.class);
        productRepository.save(product);
    }

}
