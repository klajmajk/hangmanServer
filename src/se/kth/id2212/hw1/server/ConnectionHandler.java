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
import java.util.logging.Level;
import java.util.logging.Logger;
import se.kth.id2212.common.Request;
import se.kth.id2212.common.Response;



/**
 *
 * @author Lucas
 */
public class ConnectionHandler implements Runnable {

    private Socket clientSocket;
    private GameModel game;
    private Request req;
    private Response resp;
    private RequestHandler reqHandler;

    public ConnectionHandler(Socket clientSocket) {
        // Here we pass the word to guess
        this.game = new GameModel();
        this.clientSocket = clientSocket;
        this.reqHandler = new RequestHandler(game);
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(this.clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(this.clientSocket.getInputStream());

            while (true) {
                req = (Request) ois.readObject();
                resp = reqHandler.handleRequest(req);

                oos.writeObject(resp);
                oos.reset();
                oos.flush();
            }

        } catch (IOException e) {
            System.err.println("Client disconnected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
