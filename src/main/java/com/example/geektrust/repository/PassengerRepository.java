package com.example.geektrust.repository;

import java.util.Optional;

import com.example.geektrust.entities.Passenger;;


public interface PassengerRepository {
  public boolean existByMetroCardNumber(String metroCardNumber);
  public Passenger add(Passenger passenger);
  public Optional<Passenger> findByMetroCardNumber(String metroCardNumber);
}
