package org.example.web;

import org.example.entity.Bet;
import org.example.entity.Horse;
import org.example.entity.Pair;
import org.example.entity.Result;
import org.example.entity.Rider;
import org.example.service.GameService;
import org.example.service.ShowError;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/race")
public class RaceController {

private List<Pair> pairs =new ArrayList<>();
private GameService gameService;
private ShowError showError;
public  RaceController(GameService gameService, ShowError showError){
    this.gameService =gameService;
    this.showError= showError;
}

    @GetMapping
    public ModelAndView home( ){
    ModelAndView modelAndView = new ModelAndView("race");
    modelAndView.addObject(pairs);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addPair(@Valid Horse horse, BindingResult resultHorse, @Valid Rider rider, BindingResult resultRider){
    if(resultHorse.hasErrors()){
         return showError.show(resultHorse);
    }
    if(resultRider.hasErrors()){
        return showError.show(resultRider);
    }
        Pair pair = new Pair(horse,rider);
        pairs.add(pair);
        ModelAndView modelAndView = new ModelAndView("race");
       modelAndView.addObject("pairs",pairs);

        return modelAndView;
    }

    @PostMapping("/doBet")
    public ModelAndView startGame(@Valid Bet bet,BindingResult resultBet){
    if(resultBet.hasErrors()){
        return showError.show(resultBet);
    }
      Result result =gameService.start(bet, pairs );
      ModelAndView modelAndView= new ModelAndView("resultPage");
      modelAndView.addObject("result",result);
      return modelAndView;

    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ModelAndView processError(IndexOutOfBoundsException ex){
    ModelAndView modelAndView = new ModelAndView("race");
    String error = ex.getMessage();
    modelAndView.addObject("error",error);
    return modelAndView;
    }


}
