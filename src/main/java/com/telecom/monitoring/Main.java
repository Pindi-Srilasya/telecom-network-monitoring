package com.telecom.monitoring;

public class Main {

    public static void main(String[] args) {

        Router router = new Router(
                "R001",
                "Core Router",
                "192.168.1.1"
        );

        CellTower tower = new CellTower(
                "T001",
                "City Center Tower",
                "10.0.0.1"
        );

        // Create simulators
        DeviceSimulator routerSim = new DeviceSimulator(router);
        DeviceSimulator towerSim = new DeviceSimulator(tower);

        // Create threads
        Thread routerThread = new Thread(routerSim);
        Thread towerThread = new Thread(towerSim);

        // Start simulation
        routerThread.start();
        towerThread.start();
    }
}
