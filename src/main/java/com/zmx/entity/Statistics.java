package com.zmx.entity;

import java.util.Date;

public class Statistics extends StatisticsKey {
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}