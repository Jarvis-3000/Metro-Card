package com.example.geektrust.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.PassengerTypeCount;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.StationPassengersCountRepositoryImpl;

import java.util.List;


@DisplayName("StationPassengersCountRepositoryImpl Test")
public class StationPassengersCountRepositoryTest {

    private StationPassengersCountRepositoryImpl stationPassengersCountRepositoryImpl;

    @BeforeEach
    public void setUp() {
      stationPassengersCountRepositoryImpl = new StationPassengersCountRepositoryImpl();
    }

    @Test
    @DisplayName("Test adding passenger counts for a station")
    public void testAddPassengerCount() {
        Station fromStation = Station.CENTRAL;
        PassengerType passengerType = PassengerType.ADULT;

        // Add passenger count for a station and passenger type
        stationPassengersCountRepositoryImpl.add(fromStation);
        stationPassengersCountRepositoryImpl.addPassengerCount(fromStation, passengerType);

        // Retrieve passenger counts for the station
        List<PassengerTypeCount> passengerCounts = stationPassengersCountRepositoryImpl.getPassengerCountsByStation(fromStation);
        
        assertNotNull(passengerCounts); // Assert that the passenger counts list is not null
        assertFalse(passengerCounts.isEmpty()); // Assert that the passenger counts list is not empty
        assertEquals(1, passengerCounts.size()); // Assert that there is one passenger count entry
        
        // Assert the passenger count entry
        PassengerTypeCount passengerCount = passengerCounts.get(0);
        assertEquals(passengerType, passengerCount.getPassengerType()); // Assert the passenger type
        assertEquals(1, passengerCount.getCount()); // Assert the count
    }

    @Test
    @DisplayName("Test getting passenger counts for a station")
    public void testGetPassengerCountsByStation() {
        Station fromStation = Station.CENTRAL;
        PassengerType passengerType1 = PassengerType.ADULT;
        PassengerType passengerType2 = PassengerType.KID;

        // Add passenger counts for a station
        stationPassengersCountRepositoryImpl.add(fromStation);
        stationPassengersCountRepositoryImpl.addPassengerCount(fromStation, passengerType1);
        stationPassengersCountRepositoryImpl.addPassengerCount(fromStation, passengerType2);

        // Retrieve passenger counts for the station
        List<PassengerTypeCount> passengerCounts = stationPassengersCountRepositoryImpl.getPassengerCountsByStation(fromStation);
        
        assertNotNull(passengerCounts); // Assert that the passenger counts list is not null
        assertFalse(passengerCounts.isEmpty()); // Assert that the passenger counts list is not empty
        assertEquals(2, passengerCounts.size()); // Assert that there are two passenger count entries
    }
}
