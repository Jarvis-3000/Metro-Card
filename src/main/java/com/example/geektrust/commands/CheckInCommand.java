package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;
import com.example.geektrust.services.MetroSystem;

public class CheckInCommand implements Command{
  private MetroSystem metroSystem;

  public CheckInCommand(MetroSystem metroSystem){
    this.metroSystem = metroSystem;
  }

  @Override
  public void execute(List<String> tokens) {
    String metroCardNumber = tokens.get(1);
    PassengerType passengerType = PassengerType.valueOf(tokens.get(2));
    Station station = Station.valueOf(tokens.get(3));

    metroSystem.checkIn(metroCardNumber, passengerType, station);
  }
  
}
