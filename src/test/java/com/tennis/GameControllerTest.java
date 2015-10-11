package com.tennis;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by roof on 10/7/15.
 */
public class GameControllerTest {
    private GameController gameController;
    @Before
    public void setUp() {
        gameController = new GameController();
        gameController.setGameRule(new TennisRule());
    }

    @Test
    public void gameStart() {
        assertEquals("Love - Love", gameController.displayScore());
    }

    @Test
    public void addOnePointToPlayerA_WhoGetPoint() {
        gameController.scoreToPlayerA();
        assertEquals(1, (gameController.getPlayerA().getScore()- gameController.getPlayerB().getScore()));
    }

    @Test
    public void addOnePointToPlayerB_WhoGetPoint() {
        gameController.scoreToPlayerB();
        assertEquals(1, (gameController.getPlayerB().getScore()- gameController.getPlayerA().getScore()));
    }

    @Test
    public void setScoreToZeroForBothPlayerWhenGameEnd() {
        gameController.scoreToPlayerB();
        gameController.scoreToPlayerA();
        gameController.endGame();
        assertEquals(0, gameController.getPlayerA().getScore());
        assertEquals(0, gameController.getPlayerB().getScore());
    }
}
