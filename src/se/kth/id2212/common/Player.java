/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.common;

import java.io.Serializable;

/**
 *
 * @author Lucas
 */
public class Player implements Serializable {

    private final String name;
    private int score;
    private boolean waiting;
    private Move lastMove;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.waiting = true;
        this.lastMove = Move.NONE;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the waiting
     */
    public boolean isWaiting() {
        return waiting;
    }

    /**
     * @param waiting the waiting to set
     */
    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    /**
     * @return the lastMove
     */
    public Move getLastMove() {
        return lastMove;
    }

    /**
     * @param lastMove the lastMove to set
     */
    public void setLastMove(Move lastMove) {
        this.lastMove = lastMove;
    }

}
