package com.example.demo.service;

import com.example.demo.entities.Airline;
import com.example.demo.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService implements ImpAirlineService {
    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public Airline getAirlineEntityById(int airline_id) {
        Airline airline = airlineRepository.findById(airline_id).get();
        return airline;
    }
}