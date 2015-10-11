package com.tennis;

/**
 * Created by roof on 10/9/15.
 */
public class Player {
    private int score = 0;
    public int getScore() {
        return this.score;
    }

    public void addScore() {
       this.score = this.score + 1;
    }

    public void resetScore() {
        this.score = 0;
    }
}
