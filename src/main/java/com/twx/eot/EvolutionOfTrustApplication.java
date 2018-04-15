package com.twx.eot;

import com.twx.eot.exceptions.WrongInputException;
import com.twx.eot.players.*;

public class EvolutionOfTrustApplication {
    public static void main(String[] args) throws WrongInputException {
        Player player1 = new Player("PLAYER 1",new UserBehaviour());

//        Player userPlayer = new Player("PLAYER 2",new UserBehaviour());
//        com.twx.eot.Game game1 = new com.twx.eot.Game(player1, userPlayer, 5);
//        game1.start();

//        Player cheatPlayer = new Player("2", new CheatBehaviour());
//        com.twx.eot.Game game2 = new com.twx.eot.Game(player1, cheatPlayer, 5);
//        game2.start();

//        Player cooperatePlayer = new Player("3", new CooperateBehaviour());
//        com.twx.eot.Game game3 = new com.twx.eot.Game(player1, cooperatePlayer, 5);
//        game3.start();
////
//        Player copyCat = new Player("4", new CopyCatBehaviour());
//        com.twx.eot.Game game4 = new com.twx.eot.Game(player1, copyCat, 5);
//        game4.start();

//        Player grudgePlayer = new Player("5", new GrudgeBehaviour());
//        com.twx.eot.Game game5 = new com.twx.eot.Game(player1, grudgePlayer, 5);
//        game5.start();

        Player detectivePlayer = new Player("6", new DetectiveBehaviour());
        Game game6 = new Game(player1, detectivePlayer, 5);
        game6.start();

    }
}
