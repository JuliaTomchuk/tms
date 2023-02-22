package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequestScope
@Component
public class Bet {
    @Positive
    private int bet;
    @Positive
    private int numberOfPair;

}
