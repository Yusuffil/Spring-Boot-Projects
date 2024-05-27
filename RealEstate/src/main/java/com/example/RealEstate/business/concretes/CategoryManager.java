package com.example.RealEstate.business.concretes;

import com.example.RealEstate.business.requests.UpdateCategoryRequest;
import com.example.RealEstate.business.responses.GetByCategoryIdResponse;
import com.example.RealEstate.entities.concretes.Category;

import com.example.RealEstate.business.abstracts.CategoryService;
import com.example.RealEstate.business.requests.CreateCategoryRequest;
import com.example.RealEstate.business.responses.CreateCategoryResponse;
import com.example.RealEstate.business.responses.GetAllCategoryResponses;
import com.example.RealEstate.business.rules.CategoryBusinessRules;
import com.example.RealEstate.core.utilities.exceptions.BusinessException;
import com.example.RealEstate.core.utilities.mappers.ModelMapperService;
import com.example.RealEstate.dataAccess.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    private CategoryBusinessRules categoryBusinessRules;

    @Override
    public List<GetAllCategoryResponses> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoryResponses> categoryResponses = categories.stream().
                map(category -> this.modelMapperService.forResponse().
                        map(category, GetAllCategoryResponses.class)).collect(Collectors.toList());
        return categoryResponses;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest createCategoryRequest) throws BusinessException {
        categoryBusinessRules.checkIfCategoryExists(createCategoryRequest.getName());
        Category category = modelMapperService.forRequest().map(createCategoryRequest,Category.class);
        categoryRepository.save(category);
        CreateCategoryResponse createResponse= new CreateCategoryResponse();
        createResponse.setName(category.getName());
        return createResponse;
    }

    @Override
    public boolean delete(int id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public GetByCategoryIdResponse getById(int id) {
        var category = categoryRepository.findById(id).orElseThrow();
        ModelMapper modelMapper = modelMapperService.forResponse();
        var getByIdCategoryResponse =modelMapper.map(category, GetByCategoryIdResponse.class);
        return getByIdCategoryResponse;
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {

        var category = modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        categoryRepository.save(category);
    }

}
