package com.example.geektrust.repository;

import java.util.Optional;

import com.example.geektrust.entities.MetroCard;

public interface MetroCardRepository {
  public MetroCard add(MetroCard metroCard);
  public MetroCard update(MetroCard metroCard);
  public Optional<MetroCard> findById(String metroCardNumber);
}
