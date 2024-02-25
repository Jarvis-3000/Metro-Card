package com.example.geektrust.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.geektrust.enums.PassengerType;

public class PassengerTypeCountTest {
  @Test
  public void testCreatePassengerTypeCount() {
    PassengerTypeCount count = new PassengerTypeCount(PassengerType.ADULT, 5);
    assertNotNull(count);
  }

  
}
