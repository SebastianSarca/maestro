package com.game.maestro.player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberEvaluator {
    Logger logger = LoggerFactory.getLogger(NumberEvaluator.class);

    private NumberCalculator calculator;

    @Autowired
    public NumberEvaluator(NumberCalculator calculator) {
        this.calculator = calculator;
    }

    public NumberEvaluation evaluate(int pieces){
        int nextHotNumber = calculator.findSmallerOrEqualHotNumber(pieces);
        if (isTotalHot(pieces, nextHotNumber)){
            logger.info("Need to pick from a hot number. Trying to delay, by picking 1 piece...");
            return NumberEvaluation.createHot(calculator.findSmallerOrEqualHotNumber(pieces-1));
        }

        return NumberEvaluation.create(nextHotNumber, pieces - nextHotNumber);
    }

    private boolean isTotalHot(int pieces, int hotNumber){
        return pieces == hotNumber;
    }
}
