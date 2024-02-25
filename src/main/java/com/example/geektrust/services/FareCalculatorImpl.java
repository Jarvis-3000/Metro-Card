package com.example.geektrust.services;

import com.example.geektrust.Constants;
import com.example.geektrust.entities.Passenger;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.StationCollectionRepository;

public class FareCalculatorImpl implements FareCalculator {
  private StationCollectionRepository stationCollectionRepository;

  public FareCalculatorImpl(Passenger passenger, Station currentStation,
      StationCollectionRepository stationCollectionRepository) {
    this.stationCollectionRepository = stationCollectionRepository;
  }

  @Override
  public int calculateFare(Passenger passenger, Station currentStation) {
    int fare = getAbsoluteFare(passenger.getPassengerType());
    boolean isReturnJourney = passenger.getFromStation() != currentStation;

    // if this is a return journey then discount will be given
    if (isReturnJourney) {
      int discount = calculateDiscount(fare);
      fare = fare - discount;

      addDiscountToStation(discount, currentStation);
    }

    return fare;
  }

  private void addDiscountToStation(int discount, Station currentStation) {
    stationCollectionRepository.addDiscount(currentStation, discount);
  }

  private int getAbsoluteFare(PassengerType passengerType) {
    switch (passengerType) {
      case ADULT:
        return Constants.ADULT_FARE;
      case SENIOR_CITIZEN:
        return Constants.SENIOR_CITIZEN_FARE;
      default:
        return Constants.KID_FARE;
    }
  }

  private int calculateDiscount(int fare) {
    return (fare * Constants.DISCOUNT_PERCENTAGE) / 100;
  }
}
