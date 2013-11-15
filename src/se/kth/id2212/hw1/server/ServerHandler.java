/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.kth.id2212.common.Player;
import se.kth.id2212.common.Request;
import se.kth.id2212.common.Response;
import se.kth.id2212.common.ResponseStatus;

/**
 *
 * @author Lucas
 */
public class ServerHandler implements Runnable {

    private Socket clientSocket;
    private Server parent;
    private List<Player> players;
    private Request req;
    private Response resp;
    private String playerName;

    public ServerHandler(Server parent, Socket clientSocket) {
        this.parent = parent;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(this.clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(this.clientSocket.getInputStream());

            while (true) {
                req = (Request) ois.readObject();
                switch (req.getStatus()) {
                    case CONNECT:
                        Player newPlayer = req.getPlayer();
                        parent.addPlayer(newPlayer);
                        this.playerName = newPlayer.getName();
                        this.players = parent.getPlayers();
                        resp = new Response(players, ResponseStatus.CONNECT_OK);
                        oos.writeObject(resp);
                        oos.reset();
                        oos.flush();
                        break;

                    case ASK_STATUS:
                        resp = new Response(parent.getPlayers(), parent.getCurrentStatus() );
                        resp.setRound(parent.getCurrentRound() );
                        
                        oos.writeObject(resp);
                        oos.reset();
                        oos.flush();
                        break;

                    case MAKE_MOVE:
                        // TODO
                        break;
                }
            }

        } catch (IOException e) {
            System.err.println("Client disconnected");
            parent.delPlayerByName(playerName);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
