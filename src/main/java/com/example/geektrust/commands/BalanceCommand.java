package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.MetroSystem;


public class BalanceCommand implements Command {
  private MetroSystem metroSystem;

  public BalanceCommand(MetroSystem metroSystem){
    this.metroSystem = metroSystem;
  }

  @Override
  public void execute(List<String> tokens) {
    String metroCardNumber = tokens.get(1);
    int balance = Integer.parseInt(tokens.get(2));

    metroSystem.addMetroCard(metroCardNumber, balance);
  }
}
