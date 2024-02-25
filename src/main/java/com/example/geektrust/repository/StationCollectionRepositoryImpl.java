package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.entities.StationCollection;
import com.example.geektrust.enums.Station;


public class StationCollectionRepositoryImpl implements StationCollectionRepository {
  private Map<Station, StationCollection> stationCollectionMap = new HashMap<>();

  @Override
  public StationCollection addStation(Station fromStation) {
    StationCollection stationCollection = new StationCollection();
    stationCollectionMap.put(fromStation, stationCollection);
    return stationCollection;
  }

  @Override
  public boolean exist(Station fromStation) {
    return stationCollectionMap.containsKey(fromStation);
  }

  @Override
  public StationCollection addCollection(Station fromStation, int collection) {
    StationCollection existingCollection = stationCollectionMap.get(fromStation);
    existingCollection.addCollection(collection);

    stationCollectionMap.put(fromStation, existingCollection);
    return existingCollection;
  }

  @Override
  public StationCollection addDiscount(Station fromStation, int discount) {
    StationCollection existingCollection = stationCollectionMap.get(fromStation);
    existingCollection.addDiscount(discount);

    stationCollectionMap.put(fromStation, existingCollection);
    return existingCollection;
  }

  @Override
  public StationCollection getCollectionByStation(Station fromStation) {
    return stationCollectionMap.get(fromStation);
  }

}
