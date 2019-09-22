package com.company.model;

public class Report {

    private Status status;

    public Report() {
    }

    public Report(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
