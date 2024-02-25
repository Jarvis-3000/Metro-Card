package com.example.geektrust.repository;

import com.example.geektrust.entities.StationCollection;
import com.example.geektrust.enums.Station;

public interface StationCollectionRepository {
  public boolean exist(Station fromStation);
  public StationCollection addStation(Station fromStation);
  public StationCollection addCollection(Station fromStation, int collection);
  public StationCollection addDiscount(Station fromStation, int discount);
  public StationCollection getCollectionByStation(Station fromStation);
}
