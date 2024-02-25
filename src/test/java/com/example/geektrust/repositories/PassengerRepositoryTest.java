package com.example.geektrust.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.Passenger;
import com.example.geektrust.enums.PassengerType;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.PassengerRepositoryImpl;

import java.util.Optional;

@DisplayName("PassengerRepositoryImpl Test")
public class PassengerRepositoryTest {

  private PassengerRepositoryImpl passengerRepository;

  @BeforeEach
  public void setUp() {
    passengerRepository = new PassengerRepositoryImpl();
  }

  @Test
  @DisplayName("Test Add and FindByMetroCardNumber")
  public void testAddAndFindByMetroCardNumber() {
    // given
    Passenger passenger = new Passenger("123456", PassengerType.ADULT, Station.CENTRAL);

    // when
    Passenger addedPassenger = passengerRepository.add(passenger);

    // assert
    assertNotNull(addedPassenger);
  }

  @Test
  @DisplayName("Test FindByMetroCardNumber with existent Number")
  public void testFindByMetroCardNumberWithExistentNumber() {
    // given
    Passenger passenger = new Passenger("123456", PassengerType.ADULT, Station.CENTRAL);
    passengerRepository.add(passenger);

    // when
    Optional<Passenger> foundPassenger = passengerRepository.findByMetroCardNumber("123456");

    // assert
    assertTrue(foundPassenger.isPresent()); 
  }

  @Test
  @DisplayName("Test FindByMetroCardNumber with Nonexistent Number")
  public void testFindByMetroCardNumberWithNonexistentNumber() {
    // when
    Optional<Passenger> foundPassenger = passengerRepository.findByMetroCardNumber("123456");

    // assert
    assertTrue(!foundPassenger.isPresent()); // Assert that no passenger is found
  }

  @Test
  @DisplayName("Test Exist by metro card number ")
  public void testExistByMetroCardNumber() {
    // given
    Passenger passenger = new Passenger("123456", PassengerType.ADULT, Station.CENTRAL);
    passengerRepository.add(passenger);

    // when
    boolean isPresent = passengerRepository.existByMetroCardNumber("123456");

    // assert
    assertTrue(isPresent); 
  }
}
