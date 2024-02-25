package com.example.geektrust.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StationCollectionTest {

    @Test
    @DisplayName("Test Create Station Collection")
    public void testCreateStationCollection() {
        // when
        StationCollection collection = new StationCollection();
        
        // assert
        assertNotNull(collection);
        assertEquals(0, collection.getTotalCollection());
        assertEquals(0, collection.getTotalDiscount());
    }

    @Test
    @DisplayName("Test Add Collection")
    public void testAddCollection() {
        // given
        StationCollection collection = new StationCollection();

        // when
        collection.addCollection(100);

        // assert
        assertEquals(100, collection.getTotalCollection());
    }

    @Test
    @DisplayName("Test Add Discount")
    public void testAddDiscount() {
        // given
        StationCollection collection = new StationCollection();

        // when
        collection.addDiscount(50);

        // assert
        assertEquals(50, collection.getTotalDiscount());
    }
}
