/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

import java.util.ArrayList;
import java.util.List;
import se.kth.id2212.common.Move;
import se.kth.id2212.common.Player;
import se.kth.id2212.common.ResponseStatus;


/**
 * This class contains game business logic
 * 
 * @author Adam
 */
public class GameModel {
    
    private int round;
    private List<Player> players;

    public GameModel() {     
        this.round = 0;
        this.players = new ArrayList<>();
    }
    
    
    public void checkGameStatus(){
        if(players.size() > 1) {
            this.round = (round == 0) ? 1 : round;
            
        }
    } 
    
    public synchronized void delPlayerByName(String name) {
        for (Player player : players) {
            if(player.getName().equals(name)) {
                players.remove(player);
            }
        }
    }

    public int getCurrentRound() {
        return this.round;
    }

    public ResponseStatus getCurrentStatus() {
        for (Player player : players) {
            if(player.getLastMove() == Move.NONE)
                return ResponseStatus.WAIT;
        }
        return ResponseStatus.PLAY;
    }
    
    
    public synchronized void addPlayer(Player p) {
        this.players.add(p);
    }
    
    public List<Player> getPlayers() {
        return this.players;
    }
}
