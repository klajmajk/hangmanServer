/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.common;

/**
 *
 * @author Lucas
 */
public enum ResponseStatus {

    WAIT, // Wait for other players to play
    PLAY, // You can play
    RESULT, // Displaying the results
    CONNECT_OK; // Connection ok
}
