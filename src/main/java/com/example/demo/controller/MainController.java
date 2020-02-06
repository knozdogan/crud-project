package com.example.demo.controller;

import com.example.demo.entities.Airline;
import com.example.demo.entities.Logs;
import com.example.demo.repositories.AirlineRepository;
import com.example.demo.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private LogRepository logRepository;

    @GetMapping(path = "/")
    public String showData(Model model) {
        model.addAttribute("airlines", airlineRepository.findAll());
        return "home";
    }

    @GetMapping(path = "/logs")
    public String getLogs(Model model) {
        model.addAttribute("logs", logRepository.findAll());
        return "logs";
    }

    @GetMapping(path = "/delete_all")
    public String deleteAll() {
        airlineRepository.deleteAll();
        Logs log = new Logs();
        log.setDate(log.getTimestamp());
        log.setAction("DELETED ALL");
        log.setLogs_db("Deleted all data");
        logRepository.save(log);
        return "redirect:/";
    }

    @GetMapping(path = "/delete_all_logs")
    public String deleteAllLogs() {
        logRepository.deleteAll();
        return "redirect:logs";
    }

    @GetMapping(path = "/delete")
    public String delete(int airline_id) {
        Logs log = new Logs();
        log.setDate(log.getTimestamp());
        log.setAction("DELETED");
        log.setLogs_db(log.toString(airlineRepository.findById(airline_id)));
        airlineRepository.deleteById(airline_id);
        logRepository.save(log);
        return "redirect:/";
    }

//    @GetMapping(path = "/edit/{airline_id}")
//    public String update(@PathVariable("airline_id") int airline_id,
//                         Model model){
//        Airline airline = airlineRepository.findById(airline_id).get();
//        model.addAttribute("airline", airline);
//        return "update";
//    }
//
//    @PostMapping(path = "/update/{airline_id}")
//    public String updateOp(@PathVariable("airline_id") int airline_id, @ModelAttribute Airline airline){
//        airlineRepository.save(airline);
//        return "redirect:/";
//    }

    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("airline", new Airline());
        return "create";
    }

    @PostMapping(path = "/save")
    public String saveORupdate(@ModelAttribute Airline airline) {
        airlineRepository.save(airline);
        Logs log = new Logs();
        log.setDate(log.getTimestamp());
        log.setAction("CREATE or UPDATED");
        log.setLogs_db(log.toString(airlineRepository.findById(airline.getAirline_id())));
        logRepository.save(log);
        return "redirect:/";
    }
}