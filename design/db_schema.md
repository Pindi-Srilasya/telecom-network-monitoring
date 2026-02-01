# Database Schema Design

This document describes the database schema used for the Telecom Network Monitoring System.  
The schema is designed to store information about network devices, their performance metrics, and generated alerts.

---

## 1. Devices Table

The Devices table stores static information about each network element being monitored.

### Fields:
- device_id (Primary Key): Unique identifier for each device
- device_name: Human-readable name of the device
- device_type: Type of device (router, switch, link)
- ip_address: Management IP address of the device
- status: Current operational state (UP/DOWN)

### Purpose:
This table acts as the central reference for all monitored devices in the network.

---

## 2. Metrics Table

The Metrics table stores time-series performance data collected from network devices.

### Fields:
- metric_id (Primary Key): Unique identifier for each metric record
- device_id (Foreign Key): References Devices(device_id)
- timestamp: Time when the metric was collected
- latency_ms: Network latency in milliseconds
- packet_loss_percent: Packet loss percentage
- throughput_mbps: Data throughput in Mbps
- cpu_usage_percent: CPU utilization percentage (NULL if not applicable)

### Purpose:
This table enables real-time and historical analysis of network performance.  
A unified metrics table is used, where non-applicable fields may contain NULL values depending on the device type.

---

## 3. Alerts Table

The Alerts table stores alerts generated when abnormal network behavior or faults are detected.

### Fields:
- alert_id (Primary Key): Unique identifier for each alert
- device_id (Foreign Key): References Devices(device_id)
- alert_type: Type of alert (e.g., HIGH_LATENCY, PACKET_LOSS, DEVICE_DOWN)
- severity: Severity level (INFO, WARNING, CRITICAL)
- timestamp: Time when the alert was generated
- description: Detailed explanation of the alert
- status: Alert state (ACTIVE / RESOLVED)

### Purpose:
This table helps track network issues, their severity, and resolution status.

---

## Relationships Summary

- One device can have multiple metric records
- One device can generate multiple alerts

Devices (1) → Metrics (Many)  
Devices (1) → Alerts (Many)
