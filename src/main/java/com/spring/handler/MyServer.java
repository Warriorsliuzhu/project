package com.spring.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 15-12-22.
 */
public class MyServer {
    public static void main(String[] args) {
        MyServer manager = new MyServer();
        manager.doListen();
    }

    public void doListen() {
        ServerSocket server;
        try {
            server = new ServerSocket(9991);
            while (true) {
                Socket client = server.accept();
                new Thread(new SSocket(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //服务器进程
    class SSocket implements Runnable {

        Socket client;

        public SSocket(Socket client) {
            this.client = client;
        }

        public void run() {
            DataInputStream input;
            DataOutputStream output;
            try {
                input = new DataInputStream(client.getInputStream());
                output = new DataOutputStream(client.getOutputStream());
                //
                String listMsg = input.readUTF();
                output.writeUTF("Recive:  " + listMsg + "    \r\n Thx...");
                System.out.println("Recive:   " + listMsg);
                listMsg = input.readUTF();
                output.writeUTF("Recive Second:  " + listMsg + "    \r\n Thx...");
                System.out.println("Recive Second:   " + listMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
