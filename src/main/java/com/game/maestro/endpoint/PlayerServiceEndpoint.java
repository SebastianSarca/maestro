package com.game.maestro.endpoint;

import com.game.maestro.player.MoveSolverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerServiceEndpoint {

    private MoveSolverFactory moveSolverFactory;

    @Autowired
    public PlayerServiceEndpoint(MoveSolverFactory moveSolverFactory) {
        this.moveSolverFactory = moveSolverFactory;
    }

    @GetMapping(
            value = "/maestro/move/{totalPieces}/{lastOpponentMove}")
    public int move(@PathVariable int totalPieces,
                    @PathVariable int lastOpponentMove) {
        return moveSolverFactory.createMoveResolver(totalPieces, lastOpponentMove).solveMove();
    }
}
