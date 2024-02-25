package com.example.geektrust.commands;

import java.util.List;

public interface Command {
  public void execute(List<String> tokens);
}
