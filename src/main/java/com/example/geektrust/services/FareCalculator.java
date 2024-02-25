package com.example.geektrust.services;

import com.example.geektrust.entities.Passenger;
import com.example.geektrust.enums.Station;

public interface FareCalculator {
  public int calculateFare(Passenger passenger,Station currentStation);
}
