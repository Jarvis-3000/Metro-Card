package com.example.geektrust.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.InputCommand;
import com.example.geektrust.exception.ProcessingException;

public class InputValidatorImplTest {
  private InputValidatorImpl inputValidatorImpl;

  @BeforeEach
  public void setup() {
    inputValidatorImpl = new InputValidatorImpl();
  }

  // Balance Input Test
  @Test
  @DisplayName("Test Correct Balance Input Is Valid")
  public void testCorrectBalanceInput() {
    // given
    InputCommand inputCommand = parseIputCommand("BALANCE MC1 600");

    // when
    boolean isValid = inputValidatorImpl.validateCommand(inputCommand);

    // assert
    assertTrue(isValid);
  }

  @Test
  @DisplayName("Test Incorrect Balance Command Throws Exception")
  public void testInCorrectBalanceCommandThrowsException() {
    // given
    InputCommand inputCommand = parseIputCommand("BALANCED MC1 600");

    // when
    // assert
    assertThrows(ProcessingException.class, () -> inputValidatorImpl.validateCommand(inputCommand));
  }

  @Test
  @DisplayName("Test Incorrect Balance Tokens Throws Exception")
  public void testInCorrectBalanceTokensThrowsException() {
    // given
    InputCommand inputCommand = parseIputCommand("BALANCE MC1 600 ADULT");

    // when
    // assert
    assertThrows(ProcessingException.class, () -> inputValidatorImpl.validateCommand(inputCommand));
  }

  // Check In Input Test
  @Test
  @DisplayName("Test Correct CheckIn Input Is Valid")
  public void testCorrectCheckInInput() {
    // given
    InputCommand inputCommand = parseIputCommand("CHECK_IN MC1 ADULT CENTRAL");

    // when
    boolean isValid = inputValidatorImpl.validateCommand(inputCommand);

    // assert
    assertTrue(isValid);
  }

  @Test
  @DisplayName("Test Incorrect CheckIn Command Throws Exception")
  public void testInCorrectCheckInCommandThrowsException() {
    // given
    InputCommand inputCommand = parseIputCommand("CHECKIN MC1 ADULT CENTRAL");

    // when
    // assert
    assertThrows(ProcessingException.class, () -> inputValidatorImpl.validateCommand(inputCommand));
  }

  @Test
  @DisplayName("Test Incorrect CheckIn Tokens Throws Exception")
  public void testInCorrectCheckInTokensThrowsException() {
    // given
    InputCommand inputCommand = parseIputCommand("CHECK_IN MC1 ADULT CENTRAL 600");

    // when
    // assert
    assertThrows(ProcessingException.class, () -> inputValidatorImpl.validateCommand(inputCommand));
  }

  // Print Summary Test
  @Test
  @DisplayName("Test Correct Print Summary Input Is Valid")
  public void testCorrecPrintSummaryInput() {
    // given
    InputCommand inputCommand = parseIputCommand("PRINT_SUMMARY");

    // when
    boolean isValid = inputValidatorImpl.validateCommand(inputCommand);

    // assert
    assertTrue(isValid);
  }

  @Test
  @DisplayName("Test Incorrect Print Summary Tokens Throws Exception")
  public void testInCorrecPrintSummaryTokensThrowsException() {
    // given
    InputCommand inputCommand = parseIputCommand("PRINT_SUMMARY ADULT");

    // when
    // assert
    assertThrows(ProcessingException.class, () -> inputValidatorImpl.validateCommand(inputCommand));
  }


  private InputCommand parseIputCommand(String input) {
    List<String> tokens = Arrays.asList(input.split(" "));
    String command = tokens.get(0);

    return new InputCommand(command, tokens);
  }

}
