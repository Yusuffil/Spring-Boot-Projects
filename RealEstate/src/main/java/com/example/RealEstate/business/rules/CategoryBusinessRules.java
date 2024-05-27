package com.example.RealEstate.business.rules;



import com.example.RealEstate.core.utilities.exceptions.BusinessException;
import com.example.RealEstate.dataAccess.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private CategoryRepository categoryRepository;

    public void checkIfCategoryExists(String name) throws BusinessException {
        if(this.categoryRepository.existsByName(name)){
            throw new BusinessException("Category already exists.");
        }
    }

}
