package org.example.service.impl;

import org.example.service.ErrorResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErrorResultImpl implements ErrorResult {
    @Override
    public ModelAndView get(BindingResult result) {
        ModelAndView modelAndView = new ModelAndView("race");
        Map<String, String> errors = new HashMap<>();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errors.put("err_" + fieldError.getField(), fieldError.getDefaultMessage());
        }
        modelAndView.addAllObjects(errors);
        return modelAndView;
    }
}
