package com.example.geektrust.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.geektrust.entities.PassengerTypeCount;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;

public class StationPassengersCountRepositoryImpl implements StationPassengersCountRepository {
  private Map<Station, Map<PassengerType, Integer>> stationPassengerCountsMap = new HashMap<>();

  @Override
  public Map<PassengerType, Integer> add(Station fromStation) {
    Map<PassengerType, Integer> passengerCountMap = new HashMap<>();
    stationPassengerCountsMap.put(fromStation, passengerCountMap);
    return passengerCountMap;
  }

  public boolean exist(Station fromStation) {
    return stationPassengerCountsMap.containsKey(fromStation);
  }

  @Override
  public void addPassengerCount(Station fromStation, PassengerType passengerType) {
    Map<PassengerType, Integer> passengerCountMap = stationPassengerCountsMap.get(fromStation);

    int passengersCount = passengerCountMap.getOrDefault(passengerType, 0);
    passengersCount += 1;

    // increase the count of the passengerType of the station
    stationPassengerCountsMap.get(fromStation).put(passengerType, passengersCount);
  }

  @Override
  public List<PassengerTypeCount> getPassengerCountsByStation(Station fromStation) {
    Map<PassengerType, Integer> passengerCountsMap = stationPassengerCountsMap.get(fromStation);

    List<PassengerTypeCount> passengerCounts = new ArrayList<>();

    for(Map.Entry<PassengerType, Integer> entry : passengerCountsMap.entrySet()){
      passengerCounts.add(new PassengerTypeCount(entry.getKey(), entry.getValue()));
    }

    return passengerCounts;
  }
}
