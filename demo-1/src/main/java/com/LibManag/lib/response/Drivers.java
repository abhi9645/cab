package com.LibManag.lib.response;

public class Drivers {
    String driverName;
    int driver_id;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public Drivers(String driverName, int driver_id) {
        this.driverName = driverName;
        this.driver_id = driver_id;
    }
}
