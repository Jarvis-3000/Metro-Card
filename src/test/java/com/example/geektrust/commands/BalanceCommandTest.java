package com.example.geektrust.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.config.ApplicationConfig;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class BalanceCommandTest {
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
  @DisplayName("Test Balance Command is Adding balances")
  public void testBalanceCommand() {
    // given
    String input = "BALANCE MC1 600";
    List<String> tokens = Arrays.asList(input.split(" "));
    String command = tokens.get(0);

    // when
    commandInvoker.executeCommand(command, tokens);
  }

}
