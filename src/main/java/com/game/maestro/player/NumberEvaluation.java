package com.game.maestro.player;

import java.util.StringJoiner;

public class NumberEvaluation {

    private boolean isHot;

    private int nextTarget;

    private int nextIncrement;

    private NumberEvaluation(boolean isHot, int nextTarget, int nextIncrement) {
        this.isHot = isHot;
        this.nextTarget = nextTarget;
        this.nextIncrement = nextIncrement;
    }

    public static NumberEvaluation createHot(int nextTarget) {
        return new NumberEvaluation(true, nextTarget, 1);
    }

    public static NumberEvaluation create(int nextTarget, int nextIncrement) {
        return new NumberEvaluation(false, nextTarget, nextIncrement);
    }

    public int getNextIncrement() {
        return nextIncrement;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NumberEvaluation.class.getSimpleName() + "[", "]")
                .add("isHot=" + isHot)
                .add("nextTarget=" + nextTarget)
                .add("nextIncrement=" + nextIncrement)
                .toString();
    }
}
