package com.company;

import com.company.model.Report;
import com.company.model.Route;
import com.company.model.Status;
import com.company.model.Ticket;
import com.company.repos.RouteRepo;
import com.company.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private RouteRepo routeRepo;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/order")
    public String order(Map<String, Object> model) {
        return "order";
    }

    @PostMapping("/order")
    public String addOrder(@RequestParam Integer number, @RequestParam String time, Map<String, Object> model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        Route route = routeRepo.findByNumberAndTime(number, timestamp);
        if (route != null) {
            Ticket ticket = new Ticket(number, timestamp, Status.IN_PROCESS);
            ticketRepo.save(ticket);
            model.put("tickets", ticket);
        }
        return "order";
    }

    @GetMapping("/verify")
    public String verify() {
        return "verify";
    }

    @PostMapping("/verify")
    public String verifyById(@RequestParam Integer id, Map<String, Object> model) {

        Optional<Ticket> ticket = ticketRepo.findById(id);

        if (ticket.isPresent()) {
            model.put("report", new Report(ticket.get().getPaystatus()));
        } else {
            model.put("report", new Report(Status.ERROR));
        }
        return "verify";
    }

    @GetMapping("/route")
    public String route(Map<String, Object> model) {
        Iterable<Route> routes = routeRepo.findAll();
        model.put("tickets", routes);
        return "route";
    }

    @PostMapping("/route")
    public String addRoute(@RequestParam Integer number, @RequestParam String time, Map<String, Object> model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        Route route = new Route(number, timestamp);
        routeRepo.save(route);

        Iterable<Route> routes = routeRepo.findAll();
        model.put("routes", routes);
        return "route";
    }
}

