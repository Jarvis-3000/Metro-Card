package com.example.geektrust.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.MetroCard;
import com.example.geektrust.repository.MetroCardRepositoryImpl;

import java.util.Optional;

@DisplayName("MetroCardRepositoryImpl Test")
public class MetroCardRepositoryTest {

    private MetroCardRepositoryImpl metroCardRepository;

    @BeforeEach
    public void setUp() {
        metroCardRepository = new MetroCardRepositoryImpl();
    }

    @Test
    @DisplayName("Test Add, FindById, and Update")
    public void testAddFindByIdAndUpdate() {
        // given
        MetroCard metroCard = new MetroCard("123456", 100);

        // when
        MetroCard addedMetroCard = metroCardRepository.add(metroCard);

        // assert
        assertNotNull(addedMetroCard);
        assertEquals(metroCard.getCardNumber(), addedMetroCard.getCardNumber());
        assertEquals(metroCard.getBalance(), addedMetroCard.getBalance());

    }

    @Test
    @DisplayName("Test FindById with Nonexistent ID")
    public void testFindByIdWithNonexistentId() {
        // Test finding a metro card with a nonexistent ID
        Optional<MetroCard> foundMetroCard = metroCardRepository.findById("987654");
        assertTrue(!foundMetroCard.isPresent()); // Assert that no metro card is found
    }

    @Test
    @DisplayName("Test Update Metro Card")
    public void testUpdateSuccessfull() {
        // given
        MetroCard metroCard = new MetroCard("123456", 100);
        MetroCard addedMetroCard = metroCardRepository.add(metroCard);

        // when
        MetroCard updatedMetroCard = metroCardRepository.update(addedMetroCard);

        // assert
        assertNotNull(updatedMetroCard);
    }
}
