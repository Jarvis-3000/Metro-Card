package com.example.geektrust.services;

import com.example.geektrust.Constants;
import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.StationCollectionRepository;

public class AutoRechargeImpl implements AutoRecharge {
  private MetroCard metroCard;
  private StationCollectionRepository stationCollectionRepository;

  public AutoRechargeImpl(MetroCard metroCard, StationCollectionRepository stationCollectionRepository) {
    this.metroCard = metroCard;
    this.stationCollectionRepository = stationCollectionRepository;
  }

  @Override
  public void performRecharge(int fare, Station currentStation) {
    int balance = metroCard.getBalance();
    // if auto recharge required then recharge and take service charge
    if (balance < fare) {
      int requiredMoney = fare - balance;
      int serviceCharge = (requiredMoney * Constants.AUTO_RECHARGE_SERVICE_PERCENTAGE) / 100; // 2% service charge
      
      metroCard.recharge(requiredMoney);
      addCollectionToStation(serviceCharge, currentStation);
    }
  }

  private void addCollectionToStation(int collection, Station currentStation) {
    stationCollectionRepository.addCollection(currentStation, collection);
  }
}
