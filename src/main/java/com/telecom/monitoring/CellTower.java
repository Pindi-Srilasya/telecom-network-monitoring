package com.telecom.monitoring;

import java.util.Random;

public class CellTower extends NetworkDevice {

    private Random random = new Random();

    // Constructor
    public CellTower(String deviceId, String deviceName, String ipAddress) {
        super(deviceId, deviceName, "CellTower", ipAddress);
    }

    // Override Metrics Generation
    @Override
    public void generateMetrics() {

        if (status.equals("DOWN")) {
            System.out.println(deviceName + " is DOWN. No metrics generated.");
            return;
        }

        double signalStrength = 50 + random.nextDouble() * 50;   // 50–100 %
        int connectedUsers = 50 + random.nextInt(450);           // 50–500 users
        double bandwidthUsage = 100 + random.nextDouble() * 400; // 100–500 Mbps
        double latency = 20 + random.nextDouble() * 80;          // 20–100 ms

        System.out.println("Cell Tower Metrics → " + deviceName);
        System.out.println("Signal Strength: " + signalStrength + " %");
        System.out.println("Connected Users: " + connectedUsers);
        System.out.println("Bandwidth Usage: " + bandwidthUsage + " Mbps");
        System.out.println("Latency: " + latency + " ms");
        System.out.println("----------------------------------");
    }
}
