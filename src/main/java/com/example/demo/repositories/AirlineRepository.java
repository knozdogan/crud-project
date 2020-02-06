package com.example.demo.repositories;

import com.example.demo.entities.Airline;
import org.springframework.data.repository.CrudRepository;

public interface AirlineRepository extends CrudRepository<Airline, Integer> {
}