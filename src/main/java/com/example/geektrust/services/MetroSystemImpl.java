package com.example.geektrust.services;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.entities.Passenger;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.MetroCardRepository;
import com.example.geektrust.repository.PassengerRepository;
import com.example.geektrust.repository.StationCollectionRepository;
import com.example.geektrust.repository.StationPassengersCountRepository;

public class MetroSystemImpl implements MetroSystem {
  private MetroCardRepository metroCardRepository;
  private PassengerRepository passengerRepository;
  private StationCollectionRepository stationCollectionRepository;
  private StationPassengersCountRepository stationPassengersCountRepository;
  private PrintSummary printSummary;

  // Constructor Dependency Injection
  public MetroSystemImpl(MetroCardRepository metroCardRepository,
      PassengerRepository passengerRepository,
      StationCollectionRepository stationCollectionRepository,
      StationPassengersCountRepository stationPassengersCountRepository,
      PrintSummary printSummary) {

    this.metroCardRepository = metroCardRepository;
    this.passengerRepository = passengerRepository;
    this.stationCollectionRepository = stationCollectionRepository;
    this.stationPassengersCountRepository = stationPassengersCountRepository;
    this.printSummary = printSummary;
  }

  @Override
  public MetroCard addMetroCard(String metroCardNumber, int balance) {
    MetroCard metroCard = new MetroCard(metroCardNumber, balance);

    return metroCardRepository.add(metroCard);
  }

  @Override
  public void checkIn(String metroCardNumber, PassengerType passengerType, Station currentStation) {
    MetroCard metroCard = metroCardRepository.findById(metroCardNumber)
        .orElseGet(() -> metroCardRepository.add(new MetroCard(metroCardNumber, 0)));
    Passenger passenger = passengerRepository.findByMetroCardNumber(metroCardNumber)
        .orElseGet(() -> passengerRepository.add(new Passenger(metroCardNumber, passengerType, currentStation)));

    CheckInService checkInService = new CheckInServiceImpl(passenger, metroCard, currentStation, metroCardRepository,
        passengerRepository, stationCollectionRepository, stationPassengersCountRepository);

    checkInService.performCheckIn();
  }

  @Override
  public void printSummary() {
    printSummary.print(Station.CENTRAL);
    printSummary.print(Station.AIRPORT);
  }
}
