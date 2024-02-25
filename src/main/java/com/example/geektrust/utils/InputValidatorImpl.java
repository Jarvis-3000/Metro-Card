package com.example.geektrust.utils;

import java.util.List;

import com.example.geektrust.entities.InputCommand;
import com.example.geektrust.exception.ProcessingException;

public class InputValidatorImpl implements InputValidator {

  @Override
  public boolean validateCommand(InputCommand inputCommand) throws ProcessingException {
    String command = inputCommand.getCommand();

    switch (command) {
      case "BALANCE":
        validateBalanceCommand(inputCommand.getTokens());
        return true;
      case "CHECK_IN":
        validateCheckInCommand(inputCommand.getTokens());
        return true;
      case "PRINT_SUMMARY":
        validatePrintSummaryCommand(inputCommand.getTokens());
        return true;
      default:
        throw new ProcessingException("Invalid Input Command: " + command);
    }
  }

  private void validateBalanceCommand(List<String> tokens) throws ProcessingException {
    if (tokens.size() != 3) {
      throw new ProcessingException("Invalid Number of Arguments for BALANCE command");
    }
    int balance = Integer.parseInt(tokens.get(2));
    if (balance < 0) {
      throw new ProcessingException("MetroCard Balance should be non negative");
    }
  }

  private void validateCheckInCommand(List<String> tokens) throws ProcessingException {
    if (tokens.size() != 4) {
      throw new ProcessingException("Invalid Number of Arguments for CHECK_IN command");
    }
    String passengerType = tokens.get(2);
    if (!isValidPassengerType(passengerType)) {
      throw new ProcessingException("Invalid Passenger Type: " + passengerType);
    }
    String fromStation = tokens.get(3);
    if (!isValidStation(fromStation)) {
      throw new ProcessingException("Invalid Station: " + fromStation);
    }
  }

  private boolean isValidPassengerType(String passengerType) {
    return passengerType.equals("ADULT") || passengerType.equals("SENIOR_CITIZEN") || passengerType.equals("KID");
  }

  private boolean isValidStation(String station) {
    return station.equals("AIRPORT") || station.equals("CENTRAL");
  }

  private void validatePrintSummaryCommand(List<String> tokens) throws ProcessingException {
    if (tokens.size() > 1) {
      throw new ProcessingException("PRINT_SUMMARY command should not have any arguments");
    }
  }
}
