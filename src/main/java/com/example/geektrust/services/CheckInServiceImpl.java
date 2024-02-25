package com.example.geektrust.services;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.entities.Passenger;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.MetroCardRepository;
import com.example.geektrust.repository.PassengerRepository;
import com.example.geektrust.repository.StationCollectionRepository;
import com.example.geektrust.repository.StationPassengersCountRepository;

public class CheckInServiceImpl implements CheckInService {
  private Passenger passenger;
  private MetroCard metroCard;
  private Station currentStation;
  private MetroCardRepository metroCardRepository;
  private StationCollectionRepository stationCollectionRepository;
  private StationPassengersCountRepository stationPassengersCountRepository;

  public CheckInServiceImpl(Passenger passenger, MetroCard metroCard, Station currentStation,
      MetroCardRepository metroCardRepository,
      PassengerRepository passengerRepository,
      StationCollectionRepository stationCollectionRepository,
      StationPassengersCountRepository stationPassengersCountRepository) {
    this.passenger = passenger;
    this.metroCard = metroCard;
    this.currentStation = currentStation;
    this.metroCardRepository = metroCardRepository;
    this.stationCollectionRepository = stationCollectionRepository;
    this.stationPassengersCountRepository = stationPassengersCountRepository;
  }

  @Override
  public void performCheckIn() {
    // initialize repositories
    intializeRepositories();

    // calculate fare and add discount to stationCollectionRepository
    FareCalculator fareCalculator = new FareCalculatorImpl(passenger, currentStation, stationCollectionRepository);
    int fare = fareCalculator.calculateFare(passenger, currentStation);
    addCollectionToStation(fare, currentStation);

    // auto recharge required money and add serviceCharge to stationCollectionRepository
    AutoRecharge autoRechargeService = new AutoRechargeImpl(metroCard, stationCollectionRepository);
    autoRechargeService.performRecharge(fare, currentStation);

    PassengerTracker passengerTracker = new PassengerTrackerImpl(passenger, currentStation,
        stationPassengersCountRepository);
    passengerTracker.updateStationAndCounts();

    metroCard.deduct(fare);
    metroCardRepository.update(metroCard);
  }

  private void addCollectionToStation(int collection, Station currentStation) {
    stationCollectionRepository.addCollection(currentStation, collection);
  }

  public void intializeRepositories() {
    if (!stationCollectionRepository.exist(currentStation)) {
      stationCollectionRepository.addStation(currentStation);
    }

    if (!stationPassengersCountRepository.exist(currentStation)) {
      stationPassengersCountRepository.add(currentStation);
    }
  }
}
