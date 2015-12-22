
package com.spring.server;

import uk.co.irisys.Blackfin;
import uk.co.irisys.Blackfin.Count;
import uk.co.irisys.BlackfinEngine;
import uk.co.irisys.IBlackfinCommsErrorHandler;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * This class represents the work done when a device connects to the BlackfinServer
 */
public class BlackfinComms implements Runnable, IBlackfinCommsErrorHandler {
    private final Socket m_socketToUse;
    private final BlackfinEngine m_engine;
    private boolean m_threadDone = false;
    public static Blackfin blackfin;

    /**
     * Creates a new data collection object
     *
     * @param engine      The BlackfinEngine to use
     * @param socketToUse The connected socket to use
     */
    public BlackfinComms(BlackfinEngine engine, Socket socketToUse) {
        m_socketToUse = socketToUse;
        m_engine = engine;
    }

    /**
     * Thread method
     * Connects to the specified socket and executes some API functions
     */
    public void run() {
        //Lets get some data
        long ticks = System.currentTimeMillis();
        m_threadDone = false;

        try {
            if (m_socketToUse != null && m_engine != null) {

                //Create a new Blackfin object
                blackfin = new Blackfin();

                // connect the blackfin to the socket
                try {
                    m_engine.AddNewCounterEndPoint(blackfin, m_socketToUse, null);
                    System.out.println("Device connected");
                } catch (IOException e) {
                    System.out.println("Failed to add device");

                    //Connection failed so remove the endpoint and clean up the socket
                    Socket sockToRemove = m_engine.RemoveCounterEndPoint(blackfin);

                    sockToRemove.close();

                    m_threadDone = true;
                }

                while (!m_threadDone) {
                    if ((System.currentTimeMillis() - ticks) > 30000) {
                        Thread.sleep(1000);
                        //Do some other stuff
                        String macAddress = blackfin.GetMACAddress();
                        if (macAddress != null) {
                            System.out.println(macAddress);
                        } else {
                            System.out.println("Failed to get macAddress");
                        }

                        Thread.sleep(1000);

                        //List<Count> counts = blackfin.GetLastNCounts(2);

                        Count count = blackfin.GetCurrentCount();
                        System.out.println(blackfin.GetClientConfigIP());
                        System.out.println(blackfin.GetDeviceID());
                        System.out.println(blackfin.GetDeviceName());
                        System.out.println(blackfin.GetSiteID());
                        System.out.println(blackfin.GetSiteName());
                        if (count != null) {
                            System.out.println("Got Counts");
              /*for(Count ct : counts){
              System.out.println("count 1 " + ct.countLines.get(0).toString() + " count 2 " + ct.countLines.get(1).toString());
              }*/


                            System.out.println(new Date()+"count 1 " + count.countLines.get(0).toString() + " count 2 " + count.countLines.get(1).toString());

                        } else {
                            System.out.println("Failed to get devicename");
                        }

                        ticks = System.currentTimeMillis();
                    }

                    Thread.sleep(2000);
                }

            }
        } catch (Exception e) {
            System.out.println("Thread exception " + e.getMessage());
        }

        blackfin = null;
    }

    /**
     * Callback for if a communications error occurs
     *
     * @param bf    The Blackfin upon which the error was triggered
     * @param error The error message
     * @param type  The type of the error
     */
    public void CommsError(Blackfin bf, String error, CommsErrorType type) {
        if (blackfin != bf)
            return;

        switch (type) {
            case FATAL:
                System.out.println("FATAL Error!!!" + error);
                break;
            case WARNING:
                System.out.println("Warning " + error + "####################");
                break;
        }
    }
}
