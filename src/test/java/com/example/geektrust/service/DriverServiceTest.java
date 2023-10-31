//package com.example.geektrust.service;
//
//import com.example.geektrust.model.Driver;
//import com.example.geektrust.model.Location;
//import com.example.geektrust.repository.DriverRepository;
//import org.apache.maven.surefire.shade.org.apache.commons.lang3.builder.EqualsBuilder;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//class DriverServiceTest {
//
//    private DriverRepository driverRepository;
//    private DriverService driverService;
//
//    @BeforeEach
//    void setUp() {
//        driverRepository = new DriverRepository();
//        driverService = new DriverService();
//    }
//
//    @AfterEach
//    void tearDown() {
//
//    }
//
//    @Test
//    void addDriver() {
//        String inputLine = "ADD_DRIVER D1 1 1";
//        String[] inputs = inputLine.split(" ");
//        assertNull(driverRepository.getDriver("D1"));
//        driverService.addDriver(inputs);
//        Driver driver = driverRepository.getDriver("D1");
//        assertNotNull(driver);
//    }
//}