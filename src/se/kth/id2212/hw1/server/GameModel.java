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
    
    private int triesLeft;
    private final String word;
    private String currentWordStatus;

    public GameModel(String word) {
        this.word = word;
        this.triesLeft = getMaxTries();
        
    }
    
    private int getMaxTries(){
        return 10;
    }
    

    
    
}
