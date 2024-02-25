package com.example.geektrust.entities;

import java.util.*;

public class InputCommand {
  private String command;
  private List<String> tokens;

  public InputCommand(String command, List<String> tokens){
    this.command = command;
    this.tokens = tokens;
  }

  public String getCommand(){
    return command;
  }

  public List<String> getTokens(){
    return tokens;
  }
}
