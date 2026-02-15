package com.telecom.monitoring;

public class DeviceSimulator implements Runnable {

    private NetworkDevice device;

    // Constructor
    public DeviceSimulator(NetworkDevice device) {
        this.device = device;
    }

    @Override
    public void run() {

        while (true) {

            device.generateMetrics();

            try {
                Thread.sleep(3000); // 3 seconds interval
            } catch (InterruptedException e) {
                System.out.println(device.getDeviceName() + " simulation interrupted.");
            }
        }
    }
}
