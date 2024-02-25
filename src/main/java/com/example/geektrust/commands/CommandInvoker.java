package com.example.geektrust.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandInvoker {
  private Map<String, Command> commandMap = new HashMap<>();

  public void register(String commandName, Command command) {
    commandMap.put(commandName, command);
  }

  // get the registered command
  public Command get(String commandName) {
    return commandMap.get(commandName);
  }

  // Execute the registered Command
  public void executeCommand(String commandName, List<String> tokens) {
    Command command = get(commandName);

    if (command == null) {
      // Handle Exception
      throw new IllegalArgumentException("Command not found");
    }

    command.execute(tokens);
  }
}
