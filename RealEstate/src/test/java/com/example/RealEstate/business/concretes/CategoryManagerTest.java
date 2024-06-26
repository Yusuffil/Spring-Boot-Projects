package com.example.RealEstate.business.concretes;

import com.example.RealEstate.business.requests.CreateCategoryRequest;
import com.example.RealEstate.business.requests.UpdateCategoryRequest;
import com.example.RealEstate.business.responses.GetAllCategoryResponses;
import com.example.RealEstate.business.responses.GetByCategoryIdResponse;
import com.example.RealEstate.business.rules.CategoryBusinessRules;
import com.example.RealEstate.core.utilities.exceptions.BusinessException;
import com.example.RealEstate.core.utilities.mappers.ModelMapperService;
import com.example.RealEstate.dataAccess.abstracts.CategoryRepository;
import com.example.RealEstate.entities.concretes.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class CategoryManagerTest {
    @InjectMocks
    private CategoryManager categoryManager;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private ModelMapperService modelMapperService;
    @Mock
    private CategoryBusinessRules categoryBusinessRules;

    @Test
    @Disabled
    void getAll() {
        var category1 = new Category();
        category1.setName("Tarla");
        category1.setId(1);

        List<Category> categories = new ArrayList<>();
        categories.add(category1);

        GetAllCategoryResponses categoryResponses = new GetAllCategoryResponses();
        categoryResponses.setName("Tarla");
        categoryResponses.setId(1);


        var modelMapper = new ModelMapper();
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        Mockito.when(modelMapperService.forResponse()).thenReturn(modelMapper);
        // Stream map yapamadım
        List<GetAllCategoryResponses> categoryResponsesList =new ArrayList<>();
        Mockito.when(categoryManager.getAll()).thenReturn(categoryResponsesList);

    }

    @Test
    @Disabled
    void add() throws BusinessException {
        var createCategoryRequest = new CreateCategoryRequest();
        createCategoryRequest.setName("Villa");
        var category = new Category();
        var modelMapper = new ModelMapper();
        Mockito.doNothing().when(categoryBusinessRules).checkIfCategoryExists(createCategoryRequest.getName());
        Mockito.when(modelMapperService.forRequest()).thenReturn(modelMapper);
        Mockito.when(categoryRepository.save(category)).thenReturn(category);

        var response = categoryManager.add(createCategoryRequest);
        assertEquals(createCategoryRequest.getName(), response.getName());


    }

    @Test
    void delete() {
        var id = 5;
        var response = categoryManager.delete(id);
        Assertions.assertThat(response).isTrue();
        Mockito.verify(categoryRepository, Mockito.times(1)).deleteById(id);

    }

    @Test
    void getById() {
        var id = 2;
        var category = new Category();
        category.setName("Ali GÜR");
        var getByIdCategoryResponse = new GetByCategoryIdResponse();
        var modelMapper = new ModelMapper();
        Mockito.when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        Mockito.when(modelMapperService.forResponse()).thenReturn(modelMapper);

        var response = categoryManager.getById(id);

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getName()).isEqualTo(category.getName());

        Mockito.verify(categoryRepository, Mockito.times(1)).findById(id);
        Mockito.verify(modelMapperService, Mockito.times(1)).forResponse();
    }

    @Test
    void update() {
        UpdateCategoryRequest updateCategoryRequest = new UpdateCategoryRequest();
        updateCategoryRequest.setId(5);
        updateCategoryRequest.setName("Tarla");
        var category = new Category();
        var modelMapper = new ModelMapper();

        Mockito.when(modelMapperService.forRequest()).thenReturn(modelMapper);
        Mockito.when(categoryRepository.save(category)).thenReturn(category);


    }
}