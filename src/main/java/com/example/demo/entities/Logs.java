package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    private Timestamp date;
    private String logs_db;
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLogs_db() {
        return logs_db;
    }

    public void setLogs_db(String logs_db) {
        this.logs_db = logs_db;
    }

    public Timestamp getTimestamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    public String toString(Optional<Airline> airline) {
        Airline obj = airline.get();
        return "airline_id: " + obj.getAirline_id() + "     name: " + obj.getName();
    }
}