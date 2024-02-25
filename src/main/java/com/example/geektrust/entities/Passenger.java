package com.example.geektrust.entities;

import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;

public class Passenger {
  private String metroCardNumber;
  private PassengerType passengerType;
  private Station fromStation;

  public String getMetroCardNumber() {
    return this.metroCardNumber;
  }

  public PassengerType getPassengerType() {
    return this.passengerType;
  }

  public Station getFromStation() {
    return this.fromStation;
  }

  public Passenger(String metroCardNumber, PassengerType passengerType, Station fromStation) {
    this.metroCardNumber = metroCardNumber;
    this.passengerType = passengerType;
    this.fromStation = fromStation;
  }
}
