package com.company;

import com.company.model.Report;
import com.company.model.Status;
import com.company.model.Ticket;
import com.company.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaySchedule {

    private static final String SERVICE_URL = "http://localhost:8080/pay";

    @Autowired
    private TicketRepo ticketRepo;

    @Scheduled(cron = "0 * * * * ?")
    public void scheduled() {
        payRequest();
    }

    private void payRequest() {

        RestTemplate restTemplate = new RestTemplate();
        Ticket ticket = ticketRepo.findFirstByPaystatus(Status.IN_PROCESS);

        if (ticket != null) {
            Report report = restTemplate.getForObject(SERVICE_URL, Report.class);
            ticket.setPaystatus(report.getStatus());
            ticketRepo.save(ticket);
        }
    }
}
