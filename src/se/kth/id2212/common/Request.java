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
public class Request implements Serializable {
    private Player player;
    private RequestStatus status;
    private Move move;
    private int round;
    
    public Request(Player player, RequestStatus status) {
        this.player = player;
        this.status = status;
        this.move = Move.NONE;
        this.round = 0;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the status
     */
    public RequestStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    /**
     * @return the move
     */
    public Move getMove() {
        return move;
    }

    /**
     * @param move the move to set
     */
    public void setMove(Move move) {
        this.move = move;
    }

    /**
     * @return the round
     */
    public int getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(int round) {
        this.round = round;
    }
    
    
}
