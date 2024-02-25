package com.example.geektrust.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.StationCollection;
import com.example.geektrust.enums.Station;
import com.example.geektrust.repository.StationCollectionRepositoryImpl;

@DisplayName("StationCollectionRepositoryImpl Test")
public class StationCollectionRepositoryTest {

  private StationCollectionRepositoryImpl stationCollectionRepository;

  @BeforeEach
  public void setUp() {
    stationCollectionRepository = new StationCollectionRepositoryImpl();
  }

  @Test
  @DisplayName("Test AddStation and GetCollectionByStation")
  public void testAddStationAndGetCollectionByStation() {
    // given
    Station station = Station.AIRPORT;

    // when
    StationCollection addedStationCollection = stationCollectionRepository.addStation(station);

    // assert
    assertNotNull(addedStationCollection);
    assertNotNull(stationCollectionRepository.getCollectionByStation(station));
    assertTrue(stationCollectionRepository.exist(station));
  }

  @Test
  @DisplayName("Test GetCollectionByStation with Non Existent Station")
  public void testGetCollectionByStationWithNonExistentStation() {
    // given
    Station station = Station.AIRPORT;

    // when
    StationCollection stationCollection = stationCollectionRepository.getCollectionByStation(station);

    // assert
    assertNull(stationCollection);
  }

  @Test
  @DisplayName("Test Add Collection")
  public void testAddCollectionSuccessfully() {
    // given
    Station station = Station.AIRPORT;
    stationCollectionRepository.addStation(station);

    int collectionToBeAdded = 100;

    // when
    StationCollection updatedCollection = stationCollectionRepository.addCollection(station, collectionToBeAdded);

    // assert
    assertNotNull(updatedCollection);
    assertEquals(collectionToBeAdded, updatedCollection.getTotalCollection());
    assertEquals(0, updatedCollection.getTotalDiscount());
  }

  @Test
  @DisplayName("Test Add Discount")
  public void testAddDiscountSuccessfully() {
    // given
    Station station = Station.AIRPORT;
    stationCollectionRepository.addStation(station);

    int discountToBeAdded = 100;

    // when
    StationCollection updatedCollection = stationCollectionRepository.addDiscount(station, discountToBeAdded);

    // assert
    assertNotNull(updatedCollection);
    assertEquals(discountToBeAdded, updatedCollection.getTotalDiscount());
    assertEquals(0, updatedCollection.getTotalCollection());
  }
}
