package org.example.service;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface ShowError {

    ModelAndView show(BindingResult result);
}
