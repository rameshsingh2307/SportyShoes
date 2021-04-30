package com.ecommerce.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ecommerce.entity.Product;

@Component
public class ProductValidator implements Validator {
 
   
   // This validator only checks for the CustomerForm.
   @Override
   public boolean supports(Class<?> clazz) {
      return clazz == Product.class;
   }
 
   @Override
   public void validate(Object target, Errors errors) {
	   Product productInfo = (Product) target;
 
      // Check the fields of CustomerForm.
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "NotEmpty.product.productName");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productCategory", "NotEmpty.product.productCategory");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty.product.price");
      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "NotEmpty.product.quantity");
 
      
   }
 
}
