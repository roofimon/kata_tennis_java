package com.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by roof on 10/9/15.
 */
public class TennisRuleTest {
    private GameController controller;
    private Rule tennisRule;

    @Before
    public void setUp() {
        tennisRule = new TennisRule();
        controller = new GameController();
    }

    @Test
    public void startGameScoreShouldBeLoveLove() {
        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Love - Love", score);
    }

    @Test
    public void whenPlayerAHasOnePointMoreThanPlayerBAndPlayerBScoreIsZero() {
        controller.scoreToPlayerA();

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("15 - Love", score);
    }

    @Test
    public void whenPlayerBHasOnePointThanPlayerAAndPlayerAScoreIsZero() {
        controller.scoreToPlayerB();

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Love - 15", score);
    }

    @Test
    public void whenPlayerAHasTwoPointThanPlayerBAndPlayerBScoreIsZero() {
        setScoreToPlayerA(2);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("30 - Love", score);
    }

    @Test
    public void whenPlayerAHasTwoPointThanPlayerBAndPlayerBScoreIsOne() {
        setScoreToPlayerA(3);
        setScoreToPlayerB(1);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("40 - 15", score);
    }

    @Test
    public void whenPlayerAAndPlayerBBothHaveFourPoint() {
        setScoreToPlayerA(3);
        setScoreToPlayerB(3);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Deuce", score);
    }

    @Test
    public void whenPlayerAGet2PointMoreThanPlayerBAndPlayerAScoreIsHigerThan4() {
        setScoreToPlayerA(4);
        setScoreToPlayerB(2);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Player A Win", score);
    }

    @Test
    public void whenPlayerBGet2PointMoreThanPlayerAAndPlayerBScoreIsHigerThan4() {
        setScoreToPlayerA(2);
        setScoreToPlayerB(4);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Player B Win", score);
    }

    @Test
    public void whenPlayerBGet2PointMoreThanPlayerAAndBothPlayerScoreIsHigerThan4() {
        setScoreToPlayerA(4);
        setScoreToPlayerB(6);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Player B Win", score);
    }

    @Test
    public void whenPlayerAGet2PointMoreThanPlayerBAndBothPlayerScoreIsHigerThan4() {
        setScoreToPlayerA(8);
        setScoreToPlayerB(6);
        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Player A Win", score);
    }

    @Test
    public void whenPlayerAAndPlayerBBothHaveSameScoreAndScoreIsHigerThan4() {
        setScoreToPlayerA(8);
        setScoreToPlayerB(8);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Deuce", score);
    }

    @Test
    public void whenPlayerAGet1PointMoreThanPlayerBAndBothPlayerScoreIsHigerThan4() {
        setScoreToPlayerA(5);
        setScoreToPlayerB(4);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Advantage A", score);
    }

    @Test
    public void whenPlayerBGet1PointMoreThanPlayerAAndBothPlayerScoreIsHigerThan4() {
        setScoreToPlayerA(4);
        setScoreToPlayerB(5);

        String score = tennisRule.announce(controller.getPlayerA(), controller.getPlayerB());

        assertEquals("Advantage B", score);
    }

    private void setScoreToPlayerA(int scoreA){
        for(int i = 0; i < scoreA; i++){
            controller.scoreToPlayerA();
        }
    }

    private void setScoreToPlayerB(int scoreB){
        for(int i = 0; i < scoreB; i++){
            controller.scoreToPlayerB();
        }
    }
}
