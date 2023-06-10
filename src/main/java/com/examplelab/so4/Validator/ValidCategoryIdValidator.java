package com.examplelab.so4.Validator;
import com.examplelab.so4.Validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.examplelab.so4.enity.Category;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return  category != null && category.getId() != null;
    }
}
