package com.example.geektrust.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.InputCommand;
import com.example.geektrust.exception.ProcessingException;

public class InputFileProcessingImplTest {
  private InputFileProcessingImpl inputFileProcessing;

  @BeforeEach
  public void setup() {
    inputFileProcessing = new InputFileProcessingImpl();
  }

  @Test
  @DisplayName("Test File Reading successfull")
  public void testFileReadingSuccessfull() {
    // given
    String inputFilePath = "sample_input/input1.txt";

    // when
    List<InputCommand> inputCommands = inputFileProcessing.readFile(inputFilePath);

    // assert
    assertEquals(12, inputCommands.size());
  }

  @Test
  @DisplayName("Test In Valid File Reading Throws Exception")
  public void testInValidFileReadingThrowsException() {
    // when
    String inputFilePath = "sample_input/input.txt";

    // assert
    assertThrows(ProcessingException.class, () -> inputFileProcessing.readFile(inputFilePath));
  }
}
