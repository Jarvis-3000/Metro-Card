package com.example.geektrust.commands;

import java.util.List;

import com.example.geektrust.services.MetroSystem;


public class PrintSummaryCommand implements Command{
  private MetroSystem metroSystem;

  public PrintSummaryCommand(MetroSystem metroSystem){
    this.metroSystem = metroSystem;
  }

  @Override
  public void execute(List<String> tokens) {
    metroSystem.printSummary();
  }
  
}
