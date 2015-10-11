package com.tennis;

/**
 * Created by roof on 10/7/15.
 */
public class GameController {
    private Rule gameRule;
    private Player playerA;
    private Player playerB;

    public GameController() {
        this.playerA = new Player();
        this.playerB = new Player();
    }

    public void setGameRule(Rule rule) {
        this.gameRule = rule;
    }

    public String displayScore() {
        return this.gameRule.announce(this.playerA, this.playerB);
    }

    public Player getPlayerA() {
        return this.playerA;
    }

    public Player getPlayerB() {
        return this.playerB;
    }

    public void scoreToPlayerA() {
        this.playerA.addScore();
    }

    public void scoreToPlayerB() {
        this.playerB.addScore();
    }

    public void endGame() {
        this.playerA.resetScore();
        this.playerB.resetScore();
    }
}
