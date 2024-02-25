package com.example.geektrust.services;

import com.example.geektrust.entities.Passenger;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.StationPassengersCountRepository;

public class PassengerTrackerImpl implements PassengerTracker {
  private Passenger passenger;
  private Station currentStation;
  private StationPassengersCountRepository stationPassengersCountRepository;

  public PassengerTrackerImpl(Passenger passenger, Station currentStation,
      StationPassengersCountRepository stationPassengersCountRepository) {
    this.passenger = passenger;
    this.currentStation = currentStation;
    this.stationPassengersCountRepository = stationPassengersCountRepository;
  }

  @Override
  public void updateStationAndCounts() {
    stationPassengersCountRepository.addPassengerCount(currentStation, passenger.getPassengerType());
  }

}
