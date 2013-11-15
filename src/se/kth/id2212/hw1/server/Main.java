/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.id2212.hw1.server;

/**
 *
 * @author Adam
 */
public class Main {

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
}
