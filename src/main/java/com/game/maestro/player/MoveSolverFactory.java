package com.game.maestro.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoveSolverFactory {

    private NumberEvaluator numberEvaluator;

    @Autowired
    public MoveSolverFactory(NumberEvaluator numberEvaluator) {
        this.numberEvaluator = numberEvaluator;
    }

    public MoveSolver createMoveResolver(int totalPieces, int lastPickByOpponent) {
        return new MoveSolver(totalPieces, lastPickByOpponent, numberEvaluator);

    }
}
