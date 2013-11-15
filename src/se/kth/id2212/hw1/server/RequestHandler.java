/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

import se.kth.id2212.common.Player;
import se.kth.id2212.common.Request;
import static se.kth.id2212.common.RequestStatus.ASK_STATUS;
import static se.kth.id2212.common.RequestStatus.CONNECT;
import static se.kth.id2212.common.RequestStatus.MAKE_MOVE;
import se.kth.id2212.common.Response;
import se.kth.id2212.common.ResponseStatus;

/**
 *
 * @author Adam
 */
public class RequestHandler {
    private GameModel game;

    public RequestHandler(GameModel game) {
        this.game = game;
    }    

    public Response handleRequest(Request req) {
        Response resp = null;
        switch (req.getStatus()) {
            case CONNECT:
                resp = handleConnect(req);
                break;

            case ASK_STATUS:
                resp =  handleAskStatus(req);
                break;

            case MAKE_MOVE:
                // TODO
                break;
        }
        return resp;
    }
    
    private Response handleConnect(Request req){
        Player newPlayer = req.getPlayer();
        game.addPlayer(newPlayer);
        //this.playerName = newPlayer.getName();
        return new Response(game.getPlayers(), ResponseStatus.CONNECT_OK,game.getCurrentRound() );
    }
    
    private Response handleAskStatus(Request req){
        return new Response(game.getPlayers(), game.getCurrentStatus(),game.getCurrentRound());
    }
}
