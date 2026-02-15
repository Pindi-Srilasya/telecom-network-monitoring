package com.telecom.monitoring;

public class NetworkDevice {

    // Identity Fields
    protected String deviceId;
    protected String deviceName;
    protected String deviceType;

    // Network Field
    protected String ipAddress;

    // Health Status
    protected String status; // UP / DOWN

    // Constructor
    public NetworkDevice(String deviceId, String deviceName, String deviceType, String ipAddress) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.ipAddress = ipAddress;
        this.status = "UP"; // Default status
    }

    // Start Device
    public void startDevice() {
        status = "UP";
        System.out.println(deviceName + " is now UP.");
    }

    // Stop Device
    public void stopDevice() {
        status = "DOWN";
        System.out.println(deviceName + " is now DOWN.");
    }

    // Generate Metrics (Base Method)
    public void generateMetrics() {
        System.out.println("Generating base metrics for " + deviceName);
    }

    // Getters
    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getStatus() {
        return status;
    }
}
