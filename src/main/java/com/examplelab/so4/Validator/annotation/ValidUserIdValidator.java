package com.examplelab.so4.Validator.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.examplelab.so4.enity.User;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User>
{
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context)
    {
        if (user == null)
            return true;
        return user.getId() != null;
    }
}
