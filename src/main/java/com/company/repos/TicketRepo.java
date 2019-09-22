package com.company.repos;

import com.company.model.Status;
import com.company.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepo extends CrudRepository<Ticket, Integer> {

    Ticket findFirstByPaystatus(Status paystatus);

}
