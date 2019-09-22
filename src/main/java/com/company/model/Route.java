package com.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int number;
    private Timestamp time;

    public Route() {
    }

    public Route(int routeNumber, Timestamp time) {
        this.number = routeNumber;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", number=" + number +
                ", time=" + time +
                '}';
    }
}
