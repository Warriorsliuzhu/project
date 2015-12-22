package com.spring.server;

/**
 * Created by Administrator on 15-12-22.
 */
public class StartThread implements Runnable{
    @Override
    public void run() {
        BlackfinServer s = new BlackfinServer();
        s.StartServer();
    }
}
