package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.example.geektrust.entities.MetroCard;


public class MetroCardRepositoryImpl implements MetroCardRepository{
  private Map<String, MetroCard> metroCardsMap = new HashMap<>();

  @Override
  public MetroCard add(MetroCard metroCard) {
    metroCardsMap.put(metroCard.getCardNumber(), metroCard);
    return metroCard;
  }

  @Override
  public MetroCard update(MetroCard metroCard) {
    metroCardsMap.put(metroCard.getCardNumber(), metroCard);
    return metroCard;
  }

  @Override
  public Optional<MetroCard> findById(String metroCardNumber) {
    Optional<MetroCard> metroCard = Optional.ofNullable(metroCardsMap.get(metroCardNumber));

    return metroCard;
  }
  
}
