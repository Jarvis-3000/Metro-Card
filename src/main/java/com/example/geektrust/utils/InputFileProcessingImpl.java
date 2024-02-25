package com.example.geektrust.utils;

import com.example.geektrust.entities.InputCommand;
import com.example.geektrust.exception.ProcessingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class InputFileProcessingImpl implements InputFileProcessing {
  @Override
  public List<InputCommand> readFile(String inputFilePath) throws ProcessingException {
    try {
      FileInputStream fis = new FileInputStream(inputFilePath);
      Scanner scanner = new Scanner(fis); // file to be scanned
      List<InputCommand> inputCommands = new ArrayList<>();

      // returns true if there is another line to read
      while (scanner.hasNextLine()) {
        String input = scanner.nextLine();

        // skip if empty or a comment
        if (isValidInputLine(input)) {
          continue;
        }

        // add valid input line
        inputCommands.add(parseIputCommand(input));
      }

      scanner.close(); // closes the scanner
      return inputCommands;
    } catch (IOException e) {
      throw new ProcessingException("FileProcessingException: Please check the input file and file path");
    }
  }

  public boolean isValidInputLine(String input) {
    return input.trim().isEmpty() || input.trim().startsWith("#");
  }

  public InputCommand parseIputCommand(String input) {
    List<String> tokens = Arrays.asList(input.split(" "));
    String command = tokens.get(0);

    return new InputCommand(command, tokens);
  }
}
