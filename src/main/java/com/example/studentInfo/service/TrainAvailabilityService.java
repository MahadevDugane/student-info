package com.example.studentInfo.service;

import org.springframework.stereotype.Service;

@Service
public class TrainAvailabilityService {

    private String trainNo;
    private String destination;
    private double availableSeats;

    public TrainAvailabilityService(String trainNo, String destination, double availableSeats) {
        this.trainNo = trainNo;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }
    public TrainAvailabilityService(){}

    public double getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(double availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public TrainAvailabilityService getAvailableSeats(String trainNo, String destination){
        double seat = Math.random();
        return new TrainAvailabilityService(trainNo,destination,seat);
    }
}
