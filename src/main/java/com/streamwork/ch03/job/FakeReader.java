package com.streamwork.ch03.job;

import com.streamwork.ch03.api.Event;
import com.streamwork.ch03.api.Source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class FakeReader extends Source {
    private static final long serialVersionUID = 7153550920021993542L;

    private int instance = 0;
    private final int portBase;

    private Socket socket;
    private BufferedReader reader;

    public FakeReader(String name, int parallelism, int port) {
        super(name, parallelism);

        this.portBase = port;
    }

    @Override
    public void setupInstance(int instance) {
        this.instance = instance;

        setupSocketReader(portBase + instance);
    }

    @Override
    public void getEvents(List<Event> eventCollector) {
        try {
            String vehicle = reader.readLine();
            if (vehicle == null) {
                // Exit when user closes the server.
                System.exit(0);
            }
            eventCollector.add(new FakeEvent(Integer.parseInt(vehicle)));
            System.out.println("");  // An empty line before logging new events
            System.out.println("SensorReader :: instance " + instance + " --> " + vehicle);
        } catch (IOException e) {
            System.out.println("Failed to read input: " + e);
        }
    }

    /**
     * Set up a socket based reader object that reads strings from the port.
     * @param port
     */
    private void setupSocketReader(int port) {
        try {
            socket = new Socket("localhost", port);
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
