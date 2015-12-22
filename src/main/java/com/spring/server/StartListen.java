package com.spring.server;

/**
 * Created by Administrator on 15-12-22.
 */
public class StartListen {
    public void init(){
        StartThread startThread = new StartThread();
        Thread thread = new Thread(startThread, "TimeoutChecking");
        thread.start();
    }
}
