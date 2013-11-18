/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class RandomWord {
    List<String> wordsDict;

    public RandomWord() {
        this.wordsDict = readDict();
        // System.out.println(wordsDict);
        
    }
    
    public String getRandomWord(){
        Random yourRandom = new Random();
        return wordsDict.get(yourRandom.nextInt(wordsDict.size()));
    }
    

    private List<String> readDict(){
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                words.add(line);
                line = br.readLine();
            }
            return words;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomWord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RandomWord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
