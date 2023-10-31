//package com.example.geektrust.service;
//
//import com.example.geektrust.model.Driver;
//import com.example.geektrust.model.Rider;
//import com.example.geektrust.repository.RiderRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RiderServiceTest {
//
//    private RiderRepository riderRepository;
//    private RiderService riderService;
//    private DriverService driverService;
//
//    @AfterEach
//    void tearDown() {
//        riderRepository.getRider("R2") = null;
//
//    }
//
//    @BeforeEach
//    void setUp() {
//        riderRepository = new RiderRepository();
//        riderService = new RiderService();
//        driverService = new DriverService();
//    }
//
//
//
//    @Test
//    void addRider() {
//        String inputLine = "ADD_RIDER R2 1 1";
//        String[] inputs = inputLine.split(" ");
//        assertNull(riderRepository.getRider("R2"));
//        riderService.addRider(inputs);
//        Rider rider = riderRepository.getRider("R2");
//        assertNotNull(rider);
//    }
//
//    @Test
//    void matchDriver() {
//        addDriverAndRider();
//        String inputLine = "MATCH R1";
//        String[] inputs = inputLine.split(" ");
//        assertNull(riderRepository.getCLosestDriverToRider("R1"));
//        riderService.matchDriver(inputs);
//        List<Driver> closestDrivers = riderRepository.getCLosestDriverToRider("R1");
//        assertNotNull(closestDrivers);
//        assertEquals(1, closestDrivers.size());
//    }
//
//    private void addDriverAndRider() {
//        String inputLine = "ADD_DRIVER D1 1 1";
//        String[] inputs = inputLine.split(" ");
//        driverService.addDriver(inputs);
//        String inputLine2 = "ADD_RIDER R1 1 1";
//        String[] inputs2 = inputLine.split(" ");
//        riderService.addRider(inputs);
//    }
//}