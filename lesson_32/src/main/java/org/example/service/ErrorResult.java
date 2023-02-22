package org.example.service;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface ErrorResult {

    ModelAndView get(BindingResult result);
}
