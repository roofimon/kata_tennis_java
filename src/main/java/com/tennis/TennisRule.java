package com.tennis;

public class TennisRule implements Rule {
    String[] score = {"Love", "15", "30", "40"};
    public String announce(Player playerA, Player playerB) {
        if(isDeuce(playerA, playerB)) {
            return deuceStateScore(playerA, playerB);
        } else {
            return normalStateScore(playerA, playerB);
        }
    }

    private String normalStateScore(Player playerA, Player playerB) {
        if (isStartGame(playerA, playerB)) {
            return "Love - Love";
        }
        String winner = thereIsAWinner(playerA, playerB);
        if (winner != null) return winner;
        return score[playerA.getScore()] + " - " + score[playerB.getScore()];
    }

    private String deuceStateScore(Player playerA, Player playerB) {
        String winner = thereIsAWinner(playerA, playerB);
        if (winner != null){
            return winner;
        }else if(playerA.getScore()-playerB.getScore()==1){
            return "Advantage A";
        }else if(playerB.getScore()-playerA.getScore()==1){
            return "Advantage B";
        }
        return "Deuce";
    }

    private String thereIsAWinner(Player playerA, Player playerB) {
        if(playerBwinGame(playerA, playerB)) {
            return "Player B Win";
        }else if(playerAwinGame(playerA, playerB)) {
            return "Player A Win";
        }
        return null;
    }

    private boolean isStartGame(Player playerA, Player playerB) {
        return playerA.getScore() == 0 && playerB.getScore() == 0;
    }

    private boolean isDeuce(Player playerA, Player playerB) {
        return playerA.getScore() >= 3 && playerB.getScore() >= 3;
    }

    private boolean playerAwinGame(Player playerA, Player playerB) {
        return playerA.getScore() >= 4 && playerA.getScore() > playerB.getScore() && Math.abs(playerA.getScore() - playerB.getScore()) == 2;
    }

    private boolean playerBwinGame(Player playerA, Player playerB) {
        return playerB.getScore() >= 4 && playerB.getScore() > playerA.getScore() && Math.abs(playerA.getScore() - playerB.getScore()) == 2;
    }
}
