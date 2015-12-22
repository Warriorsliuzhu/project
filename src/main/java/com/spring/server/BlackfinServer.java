package com.spring.server;

import uk.co.irisys.BlackfinEngine;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BlackfinServer listens  for incoming connections from Blackfin devices in
 * client connection mode.
 * <p/>
 * When a connection is accepted, a thread is spawned and some data collected
 * from the device
 */
public class BlackfinServer {
    private BlackfinEngine engine = new BlackfinEngine();
    private volatile boolean isRunning, finished;

    /**
     * Starts the BlackfinServer listening for connections
     */
    public void StartServer() {
        System.out.println("人数统计功能启动");
        if (isRunning)
            throw new IllegalStateException("Server already running");

        engine.StartEngine();

        isRunning = true;
        finished = false;

        int numConnections = 0;

        try {
            System.out.println("启动监听");
            ServerSocket listener = new ServerSocket(5000);

            while (isRunning) {
                Socket client = null;
                client = listener.accept();

                BlackfinComms conn_c = new BlackfinComms(engine, client);
                Thread t = new Thread(conn_c);
                t.start();

                numConnections++;

                System.out.println("Number of connections ****************** " + Integer.toString(numConnections));

                Thread.sleep(100);
            }

            listener.close();

        } catch (IOException ioe) {
            System.out.println("IOException on socket listen: " + ioe);
        } catch (InterruptedException e) {
        }

        finished = true;
    }

    /**
     * Stops the server listening for connections, waits for all connections
     * to complete, and releases allocated resources.
     */
    public void StopServer() {
        isRunning = false;

        try {
            while (!finished) {
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
        }

        engine.ShutdownEngine();
    }

    /**
     * Entry point for the application.
     * Starts a BlackfinServer
     *
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        BlackfinServer s = new BlackfinServer();
//        s.StartServer();
//    }

}
