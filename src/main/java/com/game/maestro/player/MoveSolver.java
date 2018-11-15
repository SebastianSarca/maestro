package com.game.maestro.player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoveSolver {

    private static Logger logger = LoggerFactory.getLogger(MoveSolver.class);

    private int totalPieces;
    private int lastPickByOpponent;
    private NumberEvaluator numberEvaluator;

    protected MoveSolver(int totalPieces, int lastPickByOpponent, NumberEvaluator numberEvaluator) {
        this.totalPieces = totalPieces;
        this.lastPickByOpponent = lastPickByOpponent;
        this.numberEvaluator = numberEvaluator;
        logger.info("***New move*** Total number of pieces: {}; Pieces picked by opponent: {}", totalPieces, lastPickByOpponent);
    }

    public int solveMove() {
        int result;
        if (canWin()) {
            result = totalPieces;
        } else {
            result = findNextMove();
        }
        logger.info("Maestro picks : {} piece/pieces", result);
        return result;
    }

    private int findNextMove() {
        NumberEvaluation evaluation = numberEvaluator.evaluate(totalPieces);
        logger.info("First evaluation. To evaluate: {}. Result:  {}", totalPieces, evaluation);

        int candidate = findNextMoveWithLowestGranularity(evaluation.getNextIncrement(), lastPickByOpponent);

        return candidate;
    }

    private int findNextMoveWithLowestGranularity(int pieces, int lastOpponentMove) {
        if (!isLowerGranularityNeeded(pieces) && isLegalMove(pieces, lastOpponentMove)) {
            return pieces;
        }
        NumberEvaluation evaluation = numberEvaluator.evaluate(pieces);
        logger.info("Extra evaluation. To evaluate: {}. Result:  {}", pieces, evaluation);
        return findNextMoveWithLowestGranularity(evaluation.getNextIncrement(), lastOpponentMove);
    }

    private boolean isLowerGranularityNeeded(int pieces) {
        return pieces >= 4;
    }

    private boolean isLegalMove(int pieces, int lastOpponentMove) {
        return (pieces <= lastOpponentMove * 2) ||  (lastOpponentMove == 0);
    }

    private boolean canWin() {
        return !isFirstMove() && canTakeRemainingPieces();

    }

    private boolean isFirstMove() {
        return lastPickByOpponent == 0;
    }

    private boolean canTakeRemainingPieces() {
        return lastPickByOpponent * 2 >= totalPieces;
    }
}
