package com.example.geektrust.config;

import com.example.geektrust.commands.BalanceCommand;
import com.example.geektrust.commands.CheckInCommand;
import com.example.geektrust.commands.CommandInvoker;
import com.example.geektrust.commands.PrintSummaryCommand;
import com.example.geektrust.repository.MetroCardRepository;
import com.example.geektrust.repository.MetroCardRepositoryImpl;
import com.example.geektrust.repository.PassengerRepository;
import com.example.geektrust.repository.PassengerRepositoryImpl;
import com.example.geektrust.repository.StationCollectionRepository;
import com.example.geektrust.repository.StationCollectionRepositoryImpl;
import com.example.geektrust.repository.StationPassengersCountRepository;
import com.example.geektrust.repository.StationPassengersCountRepositoryImpl;
import com.example.geektrust.services.MetroSystem;
import com.example.geektrust.services.MetroSystemImpl;
import com.example.geektrust.services.PrintSummary;
import com.example.geektrust.services.PrintSummaryImpl;

public class ApplicationConfig {
  private final MetroCardRepository metroCardRepository = new MetroCardRepositoryImpl();
  private final PassengerRepository passengerRepository = new PassengerRepositoryImpl();
  private final StationCollectionRepository stationCollectionRepository = new StationCollectionRepositoryImpl();
  private final StationPassengersCountRepository stationPassengersCountRepository = new StationPassengersCountRepositoryImpl();
  
  private final PrintSummary printSummary = new PrintSummaryImpl(stationCollectionRepository, stationPassengersCountRepository);
  
  private final MetroSystem metroSystem = new MetroSystemImpl(metroCardRepository, passengerRepository, stationCollectionRepository, stationPassengersCountRepository, printSummary);

  private final BalanceCommand balanceCommand = new BalanceCommand(metroSystem);
  private final CheckInCommand checkInCommand = new CheckInCommand(metroSystem);
  private final PrintSummaryCommand printSummaryCommand = new PrintSummaryCommand(metroSystem);

  private final CommandInvoker commandInvoker = new CommandInvoker();

  public CommandInvoker getCommandInvoker(){
    commandInvoker.register("BALANCE", balanceCommand);
    commandInvoker.register("CHECK_IN", checkInCommand);
    commandInvoker.register("PRINT_SUMMARY", printSummaryCommand);

    return commandInvoker;
  }

}
