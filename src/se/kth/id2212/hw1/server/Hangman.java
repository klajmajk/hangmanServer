/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

/**
 *
 * @author Lucas
 */
public class Hangman {

    public static String getEmptyWord(String word) {
        int length = word.length();
        String guessedWord = "";
        for (int i = 0; i < length; i++) {
            guessedWord += "-";
        }
        return guessedWord;
    }

    public static String guess(String word, char letter, String currentWord) {
        String ret = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                ret += Character.toString(letter);
            } else {
                ret += "-";
            }
        }

        return ret;
    }
    
    
}
