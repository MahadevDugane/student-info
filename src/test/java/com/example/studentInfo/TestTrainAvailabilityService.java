package com.example.studentInfo;

import com.example.studentInfo.service.TrainAvailabilityService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTrainAvailabilityService {

    @Test
    public void getAvailableSeatsReturnsCorrectValues() {
        TrainAvailabilityService service = new TrainAvailabilityService("123", "CityA", 50);
        assertEquals(50, service.getAvailableSeats());
    }

    @Test
    public void setAvailableSeatsUpdatesValue() {
        TrainAvailabilityService service = new TrainAvailabilityService();
        service.setAvailableSeats(30);
        assertEquals(30, service.getAvailableSeats());
    }

    @Test
    public void getDestinationReturnsCorrectValue() {
        TrainAvailabilityService service = new TrainAvailabilityService("123", "CityB", 20);
        assertEquals("CityB", service.getDestination());
    }

    @Test
    public void setDestinationUpdatesValue() {
        TrainAvailabilityService service = new TrainAvailabilityService();
        service.setDestination("CityC");
        assertEquals("CityC", service.getDestination());
    }

    @Test
    public void getTrainNoReturnsCorrectValue() {
        TrainAvailabilityService service = new TrainAvailabilityService("456", "CityD", 10);
        assertEquals("456", service.getTrainNo());
    }

    @Test
    public void setTrainNoUpdatesValue() {
        TrainAvailabilityService service = new TrainAvailabilityService();
        service.setTrainNo("789");
        assertEquals("789", service.getTrainNo());
    }

    @Test
    public void getAvailableSeatsGeneratesRandomSeatValue() {
        TrainAvailabilityService service = new TrainAvailabilityService();
        TrainAvailabilityService result = service.getAvailableSeats("123", "CityE");
        assertNotNull(result);
        assertEquals("123", result.getTrainNo());
        assertEquals("CityE", result.getDestination());
        assertTrue(result.getAvailableSeats() >= 0 && result.getAvailableSeats() <= 1);
    }
}
