package com.telecom.monitoring;

import java.util.Random;

public class Router extends NetworkDevice {

    private Random random = new Random();

    // Constructor
    public Router(String deviceId, String deviceName, String ipAddress) {
        super(deviceId, deviceName, "Router", ipAddress);
    }

    // Override Metrics Generation
    @Override
    public void generateMetrics() {

        if (status.equals("DOWN")) {
            System.out.println(deviceName + " is DOWN. No metrics generated.");
            return;
        }

        double latency = 10 + random.nextDouble() * 90;          // 10–100 ms
        double packetLoss = random.nextDouble() * 5;              // 0–5 %
        double throughput = 100 + random.nextDouble() * 900;      // 100–1000 Mbps
        double cpuUsage = 20 + random.nextDouble() * 70;          // 20–90 %

        System.out.println("Router Metrics → " + deviceName);
        System.out.println("Latency: " + latency + " ms");
        System.out.println("Packet Loss: " + packetLoss + " %");
        System.out.println("Throughput: " + throughput + " Mbps");
        System.out.println("CPU Usage: " + cpuUsage + " %");
        System.out.println("----------------------------------");
    }
}
