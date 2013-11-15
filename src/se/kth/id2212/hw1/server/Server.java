/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import se.kth.id2212.common.Move;
import se.kth.id2212.common.Player;
import se.kth.id2212.common.ResponseStatus;

/**
 *
 * @author Lucas
 */
public class Server {

    private final int port;
    private final int poolSize;
    private ServerSocket serverSocket = null;
    private GameModel game;

    public Server(int poolSize, int port) {
        this.poolSize = poolSize;
        this.port = port;
        this.game = new GameModel();
        this.launch();
    }


    private void launch() {
        try {
            serverSocket = new ServerSocket(this.port);

            System.out.println("Server connected :" + serverSocket.getLocalSocketAddress());

            ExecutorService executor = Executors.newFixedThreadPool(this.poolSize);
            while (true) {
                Socket socket = serverSocket.accept();
                executor.execute(new ConnectionHandler(game, socket));
                //TODO can the game start
                
                
            }

        } catch (IOException e) {
            System.out.println("Can not listen on port: " + this.port);
            System.exit(1);
        }
    }
    

}
