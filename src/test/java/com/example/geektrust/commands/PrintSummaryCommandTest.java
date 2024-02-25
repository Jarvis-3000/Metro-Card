
package com.example.geektrust.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.config.ApplicationConfig;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class PrintSummaryCommandTest {
  private CommandInvoker commandInvoker;
  private ApplicationConfig applicationConfig;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setup() {
    applicationConfig = new ApplicationConfig();
    commandInvoker = applicationConfig.getCommandInvoker();
    System.setOut(new PrintStream(outContent));


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
  @DisplayName("Test Print Summary Command")
  public void testPrintSummaryCommand() {
    // given
    String input = "PRINT_SUMMARY";
    List<String> tokens = Arrays.asList(input.split(" "));
    String command = tokens.get(0);

    // when
    commandInvoker.executeCommand(command, tokens);
  }

}
