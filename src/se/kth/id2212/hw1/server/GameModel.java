/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

import se.kth.id2212.common.ResponseStatus;


/**
 * This class contains game business logic
 * 
 * @author Adam
 */
public class GameModel {
    
    private int MAX_TRIES = 10;
    
    private int triesLeft;
    private String word;
    private String currentWordStatus;
    
    private int score;

    public GameModel() {
        this.score = 0;
        
    }

    public int getTriesLeft() {
        return triesLeft;
    }

    public String getCurrentWordStatus() {
        return currentWordStatus;
    }

    public int getScore() {
        return score;
    }
    
    public ResponseStatus getStatus() {
        if(word.equals(currentWordStatus)) {
            score++;
            return ResponseStatus.WON;
        }
        else if (triesLeft == 0) {
            score--;
            return ResponseStatus.LOST;
        }
        else
            return ResponseStatus.PLAYED;  
    }
    
    public void startNewGame() {
        this.triesLeft = MAX_TRIES;
        this.word = "elephant";
        this.currentWordStatus = Hangman.getEmptyWord(this.word);
    }
    
    public void guessLetter(char letter) {
        triesLeft--;
        this.currentWordStatus = Hangman.guess(word, letter, currentWordStatus);
    }
    
    public void guessWord(String wordTried) {
        triesLeft--;
        if (word.equals(wordTried)) {
            currentWordStatus = word;
        }

    }
    
    

    
    

    
    
}
