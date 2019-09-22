package com.company.repos;

import com.company.model.Route;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;

public interface RouteRepo extends CrudRepository<Route, Integer> {

    Route findByNumberAndTime(int number, Timestamp time);
}
