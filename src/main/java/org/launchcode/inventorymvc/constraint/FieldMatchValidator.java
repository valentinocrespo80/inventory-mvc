package org.launchcode.inventorymvc.constraint;


import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class FieldMatchValidator implements ConstraintValidator < FieldMatch, Object > {

    private String fieldFirstName;

    private String fieldSecondName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation){
        fieldFirstName = constraintAnnotation.first();
        fieldSecondName = constraintAnnotation.second();

    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context){
        try {
            final Object firstObj = BeanUtils.getPropertyDescriptor(value.getClass(), fieldFirstName);
            final Object secondObj = BeanUtils.getPropertyDescriptor(value.getClass(), fieldSecondName);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        } catch (final Exception ignore) {}
       
        return true;
    }

}
