package com.example.geektrust.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.config.ApplicationConfig;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class CheckInCommandTest {
  private CommandInvoker commandInvoker;
  private ApplicationConfig applicationConfig;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setup() {
    applicationConfig = new ApplicationConfig();
    commandInvoker = applicationConfig.getCommandInvoker();
    System.setOut(new PrintStream(outContent));
  }

  @Test
  @DisplayName("Test CheckIn Command is Check In Successfully")
  public void testCheckInCommand() {
    // add balance first
    String balanceInput = "BALANCE MC1 600";
    List<String> balanceTokens = Arrays.asList(balanceInput.split(" "));
    String balanceCommand = balanceTokens.get(0);

    commandInvoker.executeCommand(balanceCommand, balanceTokens);

    // then checkin
    String checkInInput = "CHECK_IN MC1 ADULT CENTRAL";
    List<String> checkInTokens = Arrays.asList(checkInInput.split(" "));
    String checkInCommand = checkInTokens.get(0);

    commandInvoker.executeCommand(checkInCommand, checkInTokens);
  }

  @Test
  @DisplayName("Test check in without adding metrocard balance")
  public void testCheckInWithoutBalanceAdded() {
    String checkInInput = "CHECK_IN MC1 ADULT CENTRAL";
    List<String> checkInTokens = Arrays.asList(checkInInput.split(" "));
    String checkInCommand = checkInTokens.get(0);

    commandInvoker.executeCommand(checkInCommand, checkInTokens);
  }

}
