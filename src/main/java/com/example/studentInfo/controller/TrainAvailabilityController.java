package com.example.studentInfo.controller;

import com.example.studentInfo.service.TrainAvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/traindetails")
public class TrainAvailabilityController {
    private final TrainAvailabilityService service;
    
    public TrainAvailabilityController(TrainAvailabilityService service) {
        this.service = service;
    }

    @GetMapping("/seats")
    public  TrainAvailabilityService getTrainDetails(@RequestParam String trainNo, @RequestParam String destination){
      return  service.getAvailableSeats(  trainNo,  destination);
    }

}
