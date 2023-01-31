package org.example.config;

import org.example.entity.Horse;
import org.example.entity.Pair;
import org.example.entity.Rider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Horse horseMagic() {
        return new Horse("Magic");
    }

    @Bean
    Horse horseSpirit() {
        return new Horse("Spirit");
    }

    @Bean
    Horse horseCopper() {
        return new Horse("Copper");
    }

    @Bean
    Rider riderJohn() {
        return new Rider("John");
    }

    @Bean
    Rider riderJim() {
        return new Rider("Jim");
    }

    @Bean
    Rider riderHarry() {
        return new Rider("Harry");
    }

    @Bean
    Pair pair1(@Qualifier("horseMagic") Horse horse, @Qualifier("riderHarry") Rider rider) {
        return new Pair(horse, rider);
    }

    @Bean
    Pair pair2(@Qualifier("horseCopper") Horse horse, @Qualifier("riderJim") Rider rider) {
        return new Pair(horse, rider);
    }

    @Bean
    Pair pair3(@Qualifier("horseSpirit") Horse horse, @Qualifier("riderJohn") Rider rider) {
        return new Pair(horse, rider);
    }

}
