package org.example.web;

import org.example.entity.Bet;
import org.example.entity.Horse;
import org.example.entity.Pair;
import org.example.entity.Result;
import org.example.entity.Rider;
import org.example.service.ErrorResult;
import org.example.service.GameService;
import org.example.service.PairService;
import org.example.service.impl.NoSuchPairException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


@Controller
@RequestMapping("/race")
public class RaceController {


private final GameService gameService;
private final ErrorResult errorResult;
private final Bet raceBet;
private final  PairService pairService;


public  RaceController(GameService gameService, ErrorResult errorResult,Bet raceBet, PairService pairService){
    this.gameService =gameService;
    this.errorResult= errorResult;
    this.raceBet=raceBet;
    this.pairService=pairService;

}

    @GetMapping
    public ModelAndView home( ){
    ModelAndView modelAndView = new ModelAndView("race");
    modelAndView.addObject(pairService.getPairs());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addPair(@Valid Horse horse, BindingResult resultHorse, @Valid Rider rider, BindingResult resultRider){
    if(resultHorse.hasErrors()){
         return errorResult.get(resultHorse);
    }
    if(resultRider.hasErrors()){
        return errorResult.get(resultRider);
    }
         pairService.savePair(horse, rider);

        ModelAndView modelAndView = new ModelAndView("race");
       modelAndView.addObject("pairs",pairService.getPairs());

        return modelAndView;
    }

    @PostMapping("/doBet")
    public ModelAndView startGame(@Positive Integer bet, @Positive Integer numberOfPair){


        raceBet.setBet(bet);
        raceBet.setNumberOfPair(numberOfPair);

        Result result = null;
        try {
            result = gameService.start();
        } catch (NoSuchPairException e) {
            ModelAndView modelAndView = new ModelAndView("race");
            modelAndView.addObject("noSuchPair", "no such pair");
            return modelAndView;
        }
        ModelAndView modelAndView= new ModelAndView("resultPage");
      modelAndView.addObject("result",result);
      return modelAndView;

    }




}
