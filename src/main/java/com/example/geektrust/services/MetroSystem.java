package com.example.geektrust.services;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;

public interface MetroSystem {
  public MetroCard addMetroCard(String metroCardNumber, int balance);
  public void checkIn(String metroCardNumber, PassengerType passengerType, Station fromStation);
  public void printSummary();
}
