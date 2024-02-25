package com.example.geektrust.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;


public class PassengerTest {

  @Test
  public void testCreatePassenger() {
      Passenger passenger = new Passenger("123456789", PassengerType.ADULT, Station.AIRPORT);
      assertNotNull(passenger);
  }

  // @Test
  // public void testCreatePassengerWithNullMetroCardNumber() {
  //     Passenger passenger = new Passenger(null, PassengerType.ADULT, Station.AIRPORT);
  // }

  // @Test
  // public void testCreatePassengerWithNullPassengerType() {
  //     Passenger passenger = new Passenger("123456789", null, Station.A);
  // }

  // @Test
  // public void testCreatePassengerWithNullFromStation() {
  //     Passenger passenger = new Passenger("123456789", PassengerType.ADULT, null);
  // }

}
