package com.example.geektrust.services;

import com.example.geektrust.enums.Station;

public interface AutoRecharge {
  public void performRecharge(int fare, Station curreStation);
}
