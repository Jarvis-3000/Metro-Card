package com.example.geektrust.utils;

import java.util.List;

import com.example.geektrust.entities.InputCommand;
import com.example.geektrust.exception.ProcessingException;

public interface InputFileProcessing {
  public List<InputCommand> readFile(String inputFilePath) throws ProcessingException;
}
