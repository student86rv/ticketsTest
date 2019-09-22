package com.company;

import com.company.model.Report;
import com.company.model.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PayService {

    @GetMapping("/pay")
    public Report pay() {
        return new Report(Status.values()[new Random().nextInt(Status.values().length)]);
    }
}
