package com.company.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer number;
    private Timestamp time;
    @Enumerated(EnumType.STRING)
    private Status paystatus;

    public Ticket() {
    }

    public Ticket(Integer number, Timestamp time, Status paystatus) {
        this.number = number;
        this.time = time;
        this.paystatus = paystatus;
    }

    public Status getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Status paystatus) {
        this.paystatus = paystatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumber() {
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
        return "Ticket{" +
                "id=" + id +
                ", number=" + number +
                ", time=" + time +
                '}';
    }
}
