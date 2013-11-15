/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

import se.kth.id2212.common.Request;
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
            case START_NEW_GAME:
                resp = handleStartNewGame(req);
                break;

            case GUESS_LETTER:
                resp = handleGuessLetter(req);
                break;

            case GUESS_WORD:
                resp = handleGuessWord(req);
                break;
        }
        return resp;
    }

    private Response handleStartNewGame(Request req) {
        game.startNewGame();
        return new Response(ResponseStatus.PLAYED, game.getCurrentWordStatus(), game.getTriesLeft(), game.getScore());
    }

    private Response handleGuessLetter(Request req) {
        char letter = req.getLetterGuessed();
        game.guessLetter(letter);
        return new Response(game.getStatus(), game.getCurrentWordStatus(), game.getTriesLeft(), game.getScore());
    }

    private Response handleGuessWord(Request req) {

        String word = req.getWordGuessed();
        game.guessWord(word);
        return new Response(game.getStatus(), game.getCurrentWordStatus(), game.getTriesLeft(), game.getScore());
    }

}
