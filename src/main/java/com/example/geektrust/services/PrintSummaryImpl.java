package com.example.geektrust.services;

import com.example.geektrust.entities.PassengerTypeCount;
import com.example.geektrust.entities.StationCollection;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.StationCollectionRepository;
import com.example.geektrust.repository.StationPassengersCountRepository;

import java.util.*;

public class PrintSummaryImpl implements PrintSummary {
  private StationCollectionRepository stationCollectionRepository;
  private StationPassengersCountRepository stationPassengersCountRepository;

  public PrintSummaryImpl(StationCollectionRepository stationCollectionRepository,
      StationPassengersCountRepository stationPassengersCountRepository) {
    this.stationCollectionRepository = stationCollectionRepository;
    this.stationPassengersCountRepository = stationPassengersCountRepository;
  }

  @Override
  public void print(Station station) {
    StationCollection stationCollection = stationCollectionRepository.getCollectionByStation(station);

    if(stationCollection == null){
      return;
    }

    int collection = stationCollection.getTotalCollection();
    int discount = stationCollection.getTotalDiscount();

    System.out.println("TOTAL_COLLECTION" + " " + station + " " + collection + " " + discount);

    System.out.println("PASSENGER_TYPE_SUMMARY");

    List<PassengerTypeCount> passengerTypeCounts = stationPassengersCountRepository
        .getPassengerCountsByStation(station);
    Collections.sort(passengerTypeCounts);

    for (PassengerTypeCount passengerTypeCount : passengerTypeCounts) {
      System.out.println(passengerTypeCount.getPassengerType() + " " + passengerTypeCount.getCount());
    }
  }

}
