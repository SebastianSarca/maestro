package com.game.maestro.config;

import com.maestro.player.move.MoveSolverFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MoveSolverFactory moveSolverFactory(){
        return new MoveSolverFactory();
    }
}
