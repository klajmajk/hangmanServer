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
    private int round;
    private List<Player> players;

    public Server(int poolSize, int port) {
        this.poolSize = poolSize;
        this.port = port;
        
        this.round = 0;
        this.players = new ArrayList<Player>();

        this.launch();
    }

    public synchronized void addPlayer(Player p) {
        this.players.add(p);
    }
    
    public List<Player> getPlayers() {
        return this.players;
    }

    private void launch() {
        try {
            serverSocket = new ServerSocket(this.port);

            System.out.println("Server connected :" + serverSocket.getLocalSocketAddress());

            ExecutorService executor = Executors.newFixedThreadPool(this.poolSize);
            while (true) {
                Socket socket = serverSocket.accept();
                executor.execute(new ServerHandler(this, socket));
                
                if(players.size() > 1) {
                    this.round = (round == 0) ? 1 : round;
                }
            }

        } catch (IOException e) {
            System.out.println("Can not listen on port: " + this.port);
            System.exit(1);
        }
    }
    
    public synchronized void delPlayerByName(String name) {
        for (Player player : players) {
            if(player.getName().equals(name)) {
                players.remove(player);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int poolSize = 2;
        int port = 5555;
        try {
            if (args.length > 1) {
                poolSize = Integer.parseInt(args[1]);
            }
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.out.println("USAGE: java RPSServer [poolSize] [port]");
            System.exit(1);
        }
        Server serv = new Server(poolSize, port);
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

}
