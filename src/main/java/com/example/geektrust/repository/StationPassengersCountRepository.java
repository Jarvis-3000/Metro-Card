package com.example.geektrust.repository;

import java.util.*;

import com.example.geektrust.entities.PassengerTypeCount;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;


public interface StationPassengersCountRepository {
  public Map<PassengerType, Integer> add(Station fromStation);

  public boolean exist(Station fromStation);

  public void addPassengerCount(Station fromStation, PassengerType passengerType);

  public List<PassengerTypeCount> getPassengerCountsByStation(Station fromStation);
}
