package com.example.demo.repositories;

import com.example.demo.entities.Logs;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Logs, Integer> {

}