package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.geektrust.entities.Passenger;


public class PassengerRepositoryImpl implements PassengerRepository {
  private Map<String, Passenger> passengerMap = new HashMap<>();

  @Override
  public boolean existByMetroCardNumber(String metroCardNumber) {
    return passengerMap.containsKey(metroCardNumber);
  }

  @Override
  public Passenger add(Passenger passenger) {
    passengerMap.put(passenger.getMetroCardNumber(), passenger);
    return passenger;
  }

  @Override
  public Optional<Passenger> findByMetroCardNumber(String metroCardNumber) {
    Passenger passenger = passengerMap.get(metroCardNumber);
    Optional<Passenger> optionalPassenger = Optional.ofNullable(passenger);
    return optionalPassenger;
  }
}
