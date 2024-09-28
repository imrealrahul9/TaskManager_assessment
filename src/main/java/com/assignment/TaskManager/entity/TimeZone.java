package com.assignment.TaskManager.entity;

public enum TimeZone {
    UTC("UTC"),
    PST("America/Los_Angeles"),
    EST("America/New_York"),
    GMT("GMT"),
    IST("Asia/Kolkata");

    private final String zoneId;

    TimeZone(String zoneId) {
        this.zoneId = zoneId;
    }


}
